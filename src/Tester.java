import org.antlr.runtime.*;

import caddy.db.statement.parser.*;


public class Tester
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        StringBuilder sbSql = new StringBuilder();
        
        sbSql.append("select L1.INSP_NO                       -- 신청번호                  \n");
        sbSql.append("     , L3.FIRM_CD                       -- 회계법인                  \n");
        sbSql.append("     , L3.CNTRT_NO                      -- 실행번호                  \n");
        sbSql.append("     , L3.EXT_CNT                       -- 실행차수                  \n");
        sbSql.append("     , L1.CUST_NO                       -- 고객번호                  \n");
        sbSql.append("     , L1.CUST_NM                       -- 고객명                    \n");
        sbSql.append("                                                                     \n");
        sbSql.append("     , L3.TEL_RSLT1                 as TEL_RSLT1_CD -- 통화결과1 코드\n");
        sbSql.append("     , FT_GETCODENAME(L3.TEL_RSLT1) as TEL_RSLT1_NM -- 통화결과1 명  \n");
        sbSql.append("     , L3.TEL_MEMO1                                 -- 통화결과1 메모\n");
        sbSql.append("     , L3.TEL_RSLT2                 as TEL_RSLT2_CD -- 통화결과2 코드\n");
        sbSql.append("     , FT_GETCODENAME(L3.TEL_RSLT2) as TEL_RSLT2_NM -- 통화결과2 명  \n");
        sbSql.append("     , L3.TEL_MEMO2                                 -- 통화결과2 메모\n");

        sbSql.append("  from BLN1001T L1  -- 신청(품의)원장                                \n");
        sbSql.append("  ,    BLN1050T L3  -- 만기TM원장                                    \n");

        sbSql.append(" where 1=1                                                           \n");
        sbSql.append("   and L3.INSP_NO = L1.INSP_NO(+)                                    \n");
        
        sbSql.append("@ifexist(:FIRM_CD )  -- == FIRM_CD != null                           \n");
        sbSql.append("   and L3.FIRM_CD = :FIRM_CD                                         \n");

        sbSql.append("@if (:CNTRT_NO != null && :CNTRT_NO != '')                           \n");
        sbSql.append("   and L3.CNTRT_NO= :CNTRT_NO                                        \n");

        sbSql.append("@switch(:EXT_CNT )                                                   \n");
        sbSql.append("{                                                                    \n");
        sbSql.append("    case '0000':                                                     \n");
        sbSql.append("    {                                                                \n");
        sbSql.append("   and L3.EXT_CNT = '0000'                                           \n");
        sbSql.append("        break;                                                       \n");
        sbSql.append("    }                                                                \n");
        sbSql.append("    case '0001':                                                     \n");
        sbSql.append("    {                                                                \n");
        sbSql.append("   and L3.EXT_CNT = '0001'                                           \n");
        sbSql.append("        break;                                                       \n");
        sbSql.append("    }                                                                \n");
        sbSql.append("    case '0002':                                                     \n");
        sbSql.append("    case '0003':                                                     \n");
        sbSql.append("   and L3.EXT_CNT = '0003'                                           \n");
        sbSql.append("        break;                                                       \n");
        sbSql.append("    default:                                                         \n");
        sbSql.append("   and L3.EXT_CNT = 'XXXX'                                           \n");
        sbSql.append("        break;                                                       \n");
        sbSql.append("}                                                                    \n");

        CharStream  input  = new ANTLRStringStream(sbSql.toString());
        ISQLLexer2  lexer  = new ISQLLexer2(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ISQLParser2 parser = new ISQLParser2(tokens);

        
        Token  token = null;
        int    type  = -1;
        String text  = null;
        
        do
        {
            token = lexer.nextToken();
            
            text = token.getText();
            type = token.getType();
            System.out.println("token : [ " + String.valueOf(type) + " ] : " + text);
        }
        while(type != -1);
    
        
    }
    
}
