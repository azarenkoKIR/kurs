package com.company;

public class ConstantsAndVariables {

    private static String AdminFile = "AdminFile.data";    //данные администратора
    private static String ExpertFile = "ExpertFile.data";    //данные экспертов
    private static String CreditProductsFile = "CreditProductsFile.data";   // данные кредитных продуктов
    private static String EvaluationProductsFile = "EvaluationProductsFile.data";  // данные продуктов для оценки
    private static String ExpertReviewFile="ExpertReviewFile.data";  //эксппертные оценки

    public static String getAdminFile() {
        return AdminFile;
    }

    public static String getExpertFile() {
        return ExpertFile;
    }

    public static String getCreditProductsFile() {
        return CreditProductsFile;
    }

    public static String getEvaluationProductsFile() {
        return EvaluationProductsFile;
    }

    public static String getExpertReviewFile() {
        return ExpertReviewFile;
    }
}
