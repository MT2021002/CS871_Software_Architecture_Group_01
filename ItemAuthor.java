class ItemAuthor{
    public int itemAuthor_id;
    
    public void modifyQuestion(QuestionQuery q, String reason /*, [other parameters]*/ ){
        int question_id = q.question_id;
        //...Validate if item author created question
        
        //...Logic
        if(q != null){
            try{
                respondToQuery(q, true, reason);
            }
            catch (Exception e){
                System.out.println(e);
                //...Logic
            }
        }
        //...Logic
    }
    
    public void rejectQuery(QuestionQuery q, String reason) throws Exception{
        respondToQuery(q, false, reason);
    }
    
    
    public void respondToQuery(QuestionQuery query, boolean didAccept, String response) throws Exception{
        if(query.queryState != "Under Review") throw new Exception("Query is no longer under review");
        query.queryState = didAccept?"Accepted":"Rejected";
        query.queryResponseText = response;
        InMemoryStorage.questionQueriesUnderReview.remove(query);
    }
}
