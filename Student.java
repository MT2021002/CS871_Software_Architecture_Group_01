class Student{
    public int student_id;
    
    
    public void raiseQuestionQuery(int exam_id, int question_id, String queryText, boolean queryRaised_DURING_exam) throws Exception{
        
        QueryWindowValidator validator = new QueryWindowValidator(exam_id);
        if(!validator.isQueryAllowed()) throw new Exception("Exam does not accept queries");
        if(!validator.isQueryWindowOpen()) throw new Exception("Exam window closed");
        
        QuestionQuery query = new QuestionQuery();
        query.exam_id = exam_id;
        query.question_id = question_id;
        query.queryText = queryText;
        query.student_id = this.student_id;
        query.queryRaised_DURING_exam = queryRaised_DURING_exam;
        query.queryState = "Being validated";
        InMemoryStorage.questionQueries.add(query);
    }
}
