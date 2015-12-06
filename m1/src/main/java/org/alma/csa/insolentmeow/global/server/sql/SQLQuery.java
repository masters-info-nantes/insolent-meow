package org.alma.csa.insolentmeow.global.server.sql;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.SimpleConnector;
import org.alma.csa.insolentmeow.global.server.sql.connexion.SqlFromConnexionMgr;
import org.alma.csa.insolentmeow.global.server.sql.connexion.SqlToConnexionMgr;
import org.alma.csa.insolentmeow.global.server.sql.database.SqlFromDatabase;
import org.alma.csa.insolentmeow.global.server.sql.database.SqlToDatabase;

public class SQLQuery extends SimpleConnector {

    SqlFromConnexionMgr sqlFromConnexionMgr;
    SqlToConnexionMgr sqlToConnexionMgr;
    SqlFromDatabase sqlFromDatabase;
    SqlToDatabase sqlToDatabase;

    public SQLQuery(IContext context){
        super(context);
        sqlFromConnexionMgr = new SqlFromConnexionMgr();
        this.getContext().attach(sqlFromConnexionMgr,"sqlFromConnexionMgr");
        sqlToConnexionMgr = new SqlToConnexionMgr();
        this.getContext().attach(sqlToConnexionMgr,"sqlToConnexionMgr");
        sqlFromDatabase = new SqlFromDatabase();
        this.getContext().attach(sqlFromDatabase,"sqlFromDatabase");
        sqlToDatabase = new SqlToDatabase();
        this.getContext().attach(sqlToDatabase,"sqlToDatabase");
    }
}
