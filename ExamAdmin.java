class ExamAdmin{
    public int admin_id;
    
    public void validateQuestionQuery(QuestionQuery query, boolean queryValid, String reasonOfRejection){
        if(!queryValid){
            query.queryState = "Query Rejected";
            query.queryResponseText = reasonOfRejection;
            return;
        }
        
        query.queryState = "Under Review";
        InMemoryStorage.questionQueriesUnderReview.add(query);
        InMemoryStorage.questionQueries.remove(query);
    }
}
