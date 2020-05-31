package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class Serwer {

    public static class ClientHandler implements Runnable {

        private Socket client_socket;

        private ObjectInputStream obj_input;
        private ObjectOutputStream obj_output;


        public ClientHandler(Socket client_socket) {
            this.client_socket = client_socket;
        }

        public void run() {
            try {

                obj_output = new ObjectOutputStream(client_socket.getOutputStream());
                obj_input = new ObjectInputStream(client_socket.getInputStream());


                while (true) {
                    try {
                        int menu_punkt = (int) obj_input.readObject();
                        System.out.println("\n==========================================");
                        System.out.print("Пункт меню "+ menu_punkt+": ");
                        switch (menu_punkt) {

                            case 1: {
                                System.out.println("Авторизация в качестве эксперта");
                                String login = (String) obj_input.readObject();
                                String parol = (String) obj_input.readObject();
                                Serializator s = new Serializator();
                                int result = 0;
                                Map<String,User>map = s.deserilaizationExpert();
                                for(User expert : map.values()){
                                    if(expert.ChekLoginParol(login, parol) == 1){
                                        result = 1;
                                        break;
                                    }
                                }
                                obj_output.writeObject(result);
                                if (result == 1) {
                                    System.out.println("==========================================");
                                    System.out.println("Эксперт: " + login + " авторизировался...");
                                    System.out.println("Локальный порт "+ client_socket.getLocalPort());
                                    System.out.println("IP-адрес "+ client_socket.getInetAddress().getHostAddress());
                                    System.out.println("==========================================");
                                }
                            }break;
                            case 2: {
                                System.out.println("Авторизация в качестве администратора");
                                String login = (String) obj_input.readObject();
                                String parol = (String) obj_input.readObject();
                                Serializator s = new Serializator();
                                int result = 0;
                                Map<String,User>map = s.deserilaizationAdmin();
                                for(User admin : map.values()){
                                    if(admin.ChekLoginParol(login, parol) == 1){
                                        result = 1;
                                        break;
                                    }
                                }
                                obj_output.writeObject(result);
                                if (result == 1) {
                                    obj_output.writeObject(1);
                                    System.out.println("==========================================");
                                    System.out.println("Администратор: " + login + " авторизировался...");
                                    System.out.println("Локальный порт "+ client_socket.getLocalPort());
                                    System.out.println("IP-адрес "+ client_socket.getInetAddress().getHostAddress());
                                    System.out.println("==========================================");
                                }
                            }break;
                            case 3: {
                                System.out.println("Добавление кредитного продукта");
                                CreditProduct credit = acceptCreditProduct();
                                Serializator serl = new Serializator();

                                if (serl.serilaization(credit)) {
                                    System.out.println("Добавлен продукт " + credit.getName_of_product());
                                    obj_output.writeObject(1);
                                } else {
                                    System.out.println("Продукт " + credit.getName_of_product() + " уже существует...");
                                    obj_output.writeObject(0);
                                }
                            }break;
                            case 4: {
                                System.out.println("Отправка клиенту данных о кредитных продуктах");
                                Serializator serl = new Serializator();
                                Map<String, CreditProduct> map = serl.deserilaizationMap();
                                obj_output.writeObject(map.size());
                                for(CreditProduct credit : map.values()){
                                     giveCreditProduct(credit);
                                }
                            }break;
                            case 5:{
                                System.out.println("Получение отредактированных данных");
                                int size = (int)obj_input.readObject();

                                if(size==0){
                                    File file = new File(ConstantsAndVariables.getCreditProductsFile());
                                    file.delete();   //удаление файла
                                }
                                else {

                                    Map<String, CreditProduct> map = new HashMap<String, CreditProduct>();
                                    Serializator serl = new Serializator();

                                    for (int i = 0; i < size; i++) {
                                        CreditProduct credit = acceptCreditProduct();
                                        map.put(credit.getName_of_product(), credit);
                                    }

                                    if (serl.serilaization(map)) {
                                        obj_output.writeObject(1);
                                    }else obj_output.writeObject(0);
                                }
                            }break;
                            case 6: {  //получение данных об экспернтой задаче
                                System.out.println("Получение данных о новой экспертной задаче");
                                ExpertReview review = new ExpertReview();
                                Serializator serl = new Serializator();
                                Map<String, CreditProduct> map =new HashMap<String, CreditProduct>();

                                int size = (int)obj_input.readObject();
                                System.out.print("Кредитные продукты для оценок: ");
                                for (int i = 0; i < size; i++) {
                                    CreditProduct credit = acceptCreditProduct();
                                    map.put(credit.getName_of_product(), credit);
                                    System.out.print(credit.getName_of_product()+"; ");
                                }
                                System.out.println();
                                if (serl.serilaizationEvaluationProducts(map)) {
                                    serl.serilaizationExpertReview(review);
                                    obj_output.writeObject(1);
                                    System.out.println("Данные получены и сериализованы");
                                }else {
                                    obj_output.writeObject(0);
                                    System.out.println("Ошибка получения или сериализации данных");
                                }
                            }break;
                            case 7: {   // отправка данных экспертной задачи
                                System.out.println("Отправка клиенту данных об экспертной задаче");
                                Serializator serl = new Serializator();
                                Map<String, CreditProduct> map = serl.deserilaizationEvaluationProducts();
                                ExpertReview review = serl.deserilaizationExpertReview();

                                obj_output.writeObject(map.size());

                                for(CreditProduct credit : map.values()){
                                    giveCreditProduct(credit);
                                }

                                obj_output.writeObject(review.getExpert_value());
                                obj_output.writeObject(review.getReview());
                            }break;
                            case 8:{  //получение оценки
                                System.out.println("Получение экспертных оценок от эксперта");
                                Serializator serl = new Serializator();
                                ExpertReview review= serl.deserilaizationExpertReview();
                                    ExpertReview var= new ExpertReview();
                                    var.setReview((double[][]) obj_input.readObject());
                                    var.setExpert_value((int) obj_input.readObject());
                                if(review.getExpert_value()<4) {
                                    for(int i =0;i<var.getExpert_value()-1;i++) {
                                        for (int j = 0; j < 12; j++) {
                                            review.setReview(i, j, var.getReview(i, j));
                                        }
                                    }
                                    for (int j = 0; j < 12; j++) {
                                        review.setReview(review.getExpert_value(), j, var.getReview(var.getExpert_value()-1, j));
                                    }
                                    review.ExpertValueIncrement();
                                }
                                    if (serl.serilaizationExpertReview(review)) {
                                        System.out.println("Экспертная оценка заполнена");
                                        obj_output.writeObject(1);
                                    } else {
                                        System.out.println("Ошибка сериализации экспертной оценки");
                                        obj_output.writeObject(0);
                                    }


                            }break;
                            case 9:{ //отправка экспертных оценок
                                System.out.println("Отправка данных о проставленных оценках клиенту");
                                Serializator serl = new Serializator();
                                Map<String, CreditProduct> map = serl.deserilaizationEvaluationProducts();
                                ExpertReview review = serl.deserilaizationExpertReview();

                                obj_output.writeObject(map.size());

                                for(CreditProduct credit : map.values()){
                                    giveCreditProduct(credit);
                                }

                                obj_output.writeObject(review.getExpert_value());
                                obj_output.writeObject(review.getReview());
                            }break;
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
                obj_output.close();
                obj_input.close();
                client_socket.close();
            } catch (IOException e) {
                System.out.println("Ошибка работы: " + e);
            }
        }

        public CreditProduct acceptCreditProduct() throws IOException, ClassNotFoundException {  //получение кредитного продукта
            CreditProduct credit = new CreditProduct();

            credit.setName_of_product((String) obj_input.readObject());
            credit.setMaturity_date((int) obj_input.readObject());
            credit.setInitial_amount((double) obj_input.readObject());
            credit.setInterest_rate((double) obj_input.readObject());
            credit.setRecurring_payments((double) obj_input.readObject());
            credit.setEarly_repayment((boolean)obj_input.readObject());  //NEN
            return  credit;
        }

        public void giveCreditProduct(CreditProduct credit) throws IOException {  //отправка кредитного продукта
            obj_output.writeObject(credit.getName_of_product());
            obj_output.writeObject(credit.getMaturity_date());
            obj_output.writeObject(credit.getInitial_amount());
            obj_output.writeObject(credit.getInterest_rate());
            obj_output.writeObject(credit.getRecurring_payments());
            obj_output.writeObject(credit.isEarly_repayment());  //NEN
        }
    }

        public static void main(String[] args) {

            ServerSocket sock;
            try {
                sock = new ServerSocket(1024);//создаем серверный сокет работающий локально по порту 1024
                System.out.println("Сервер ожидает запросов на подключение...");
                while (true) {
                    Socket client = sock.accept();//сработает, когда клиент подключится, для него выделится отдельный сокет
                    new Thread(new ClientHandler(client)).start();//  новый поток обработки сообщений нового клиента
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }

        }

}










































           /*User adm=new User("admin","111");
            User e1 = new User("exp1","111");
            User e2 = new User("exp2","222");
            User e3 = new User("exp3","333");
            User e4 = new User("exp4","444");
            Serializator s =new Serializator();
            s.serilaizationAdmin(adm);
            s.serilaizationExpert(e1);
            s.serilaizationExpert(e2);
            s.serilaizationExpert(e3);
            s.serilaizationExpert(e4);*/