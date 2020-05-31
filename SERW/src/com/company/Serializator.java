package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Serializator {

    public boolean serilaizationAdmin(User user) {

        Map<String, User> map = new HashMap<String, User>();
        map = deserilaizationAdmin();

        if (map.containsKey(user.getLogin())) {  //boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
            return false;
        }

        map.put(user.getLogin(), user);

        File file = new File(ConstantsAndVariables.getAdminFile());
        file.delete();   //удаление файла

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ConstantsAndVariables.getAdminFile()))) {
            oos.writeObject(map);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public Map<String,User> deserilaizationAdmin() {
        Map<String,User>map=new HashMap<String,User>();
        File file =new File(ConstantsAndVariables.getAdminFile());
        if(file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ConstantsAndVariables.getAdminFile()))) {
                map = ((Map<String, User>) ois.readObject());
                System.out.println("Чтение из файла "+ ConstantsAndVariables.getAdminFile());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return map;
    }

    public boolean serilaizationExpert(User user) {

        Map<String, User> map = new HashMap<String, User>();
        map = deserilaizationExpert();

        if (map.containsKey(user.getLogin())) {  //boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
            return false;
        }

        map.put(user.getLogin(), user);

        File file = new File(ConstantsAndVariables.getExpertFile());
        file.delete();   //удаление файла

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ConstantsAndVariables.getExpertFile()))) {
            oos.writeObject(map);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public Map<String,User> deserilaizationExpert() {
        Map<String,User>map=new HashMap<String,User>();
        File file =new File(ConstantsAndVariables.getExpertFile());
        if(file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ConstantsAndVariables.getExpertFile()))) {
                map = ((Map<String, User>) ois.readObject());
                System.out.println("Чтение из файла "+ ConstantsAndVariables.getExpertFile());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return map;
    }

    public boolean serilaization(CreditProduct credit) {  //запись в файл
        Map<String, CreditProduct> map = new HashMap<String, CreditProduct>();
        map = deserilaizationMap();

        if (map.containsKey(credit.getName_of_product())) {  //boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
            return false;
        }

        map.put(credit.getName_of_product(), credit);

        File file = new File(ConstantsAndVariables.getCreditProductsFile());
        file.delete();   //удаление файла

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ConstantsAndVariables.getCreditProductsFile()))) {
            oos.writeObject(map);
            System.out.println("Запись в файл "+ ConstantsAndVariables.getCreditProductsFile());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public Map<String,CreditProduct> deserilaizationMap(){  //чтение из файла
        Map<String,CreditProduct>map=new HashMap<String,CreditProduct>();
        File file =new File(ConstantsAndVariables.getCreditProductsFile());
        if(file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ConstantsAndVariables.getCreditProductsFile()))) {
                map = ((Map<String, CreditProduct>) ois.readObject());
                System.out.println("Чтение из файла "+ ConstantsAndVariables.getCreditProductsFile());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return map;
    }

    public boolean serilaization(Map<String,CreditProduct> map){

        File file = new File(ConstantsAndVariables.getCreditProductsFile());
        file.delete();   //удаление файла

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ConstantsAndVariables.getCreditProductsFile()))) {
            oos.writeObject(map);
            System.out.println("Запись в файл "+ ConstantsAndVariables.getCreditProductsFile());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public boolean serilaizationExpertReview(ExpertReview review){

        File file = new File(ConstantsAndVariables.getExpertReviewFile());
        file.delete();   //удаление файла

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ConstantsAndVariables.getExpertReviewFile()))) {
            oos.writeObject(review);
            System.out.println("Запись в файл "+ ConstantsAndVariables.getExpertReviewFile());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public ExpertReview deserilaizationExpertReview(){  //чтение из файла

        ExpertReview review = new ExpertReview();
        File file =new File(ConstantsAndVariables.getExpertReviewFile());
        if(file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ConstantsAndVariables.getExpertReviewFile()))) {
                review = (ExpertReview) ois.readObject();
                System.out.println("Чтение из файла "+ ConstantsAndVariables.getExpertReviewFile());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return review;
    }

    public boolean serilaizationEvaluationProducts(Map<String,CreditProduct> map){  //сериализация кредитных продуктов для экспертных оценок

        File file = new File(ConstantsAndVariables.getEvaluationProductsFile());
        file.delete();   //удаление файла

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ConstantsAndVariables.getEvaluationProductsFile()))) {
            oos.writeObject(map);
            System.out.println("Запись в файл "+ ConstantsAndVariables.getEvaluationProductsFile());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public Map<String,CreditProduct> deserilaizationEvaluationProducts(){  //десериализация кредитных продуктов для экспертных оценок
        Map<String,CreditProduct>map=new HashMap<String,CreditProduct>();
        File file =new File(ConstantsAndVariables.getEvaluationProductsFile());
        if(file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ConstantsAndVariables.getEvaluationProductsFile()))) {
                map = ((Map<String, CreditProduct>) ois.readObject());
                System.out.println("Чтение из файла "+ ConstantsAndVariables.getEvaluationProductsFile());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return map;
    }
}
