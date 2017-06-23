package helper;

import config.ProgramConstants;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueryBuilderTest {

    private String googleLink = ProgramConstants.GOOGLE + ProgramConstants.SEARCH_QUERY;

    @Test
    public void testGenerateQueryForSingleWord() {
        String word = "test";
        assertEquals(QueryBuilder.generateQuery(word), googleLink + word);
    }

    @Test
    public void testGenerateQueryForSeveralWords() {
        String sentence = "test test test";
        String sentenceForQuery = "test+test+test";
        assertEquals(QueryBuilder.generateQuery(sentence), googleLink + sentenceForQuery);
    }

    @Test
    public void testGenerateQueryForEmptyString() {
        String word = "";
        assertEquals(QueryBuilder.generateQuery(word), googleLink);
    }

    @Test
    public void testGenerateQueryForUrlEncodeString() {
        String word = "&&&&&";
        System.out.println(QueryBuilder.generateQuery(word));
        assertEquals(QueryBuilder.generateQuery(word), googleLink+"%26%26%26%26%26");
    }

}
