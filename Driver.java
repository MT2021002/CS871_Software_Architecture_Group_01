class Driver{
    public static void main(String args[]){
        
        //...Student raises query
        Student s = new Student();
        s.student_id = 1;
        try{
            s.raiseQuestionQuery(2,1,"Question unclear", true);
            System.out.println("Query raised");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
