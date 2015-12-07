package org.alma.csa.insolentmeow.global.server.sql;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.Glue;
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
        this.getContext().attach(sqlFromConnexionMgr,"DBQueryOutPort");
        sqlToConnexionMgr = new SqlToConnexionMgr();
        this.getContext().attach(sqlToConnexionMgr,"DBQueryInPort");
        sqlFromDatabase = new SqlFromDatabase();
        this.getContext().attach(sqlFromDatabase,"QueryDatabaseOutPort");
        sqlToDatabase = new SqlToDatabase();
        this.getContext().attach(sqlToDatabase,"QueryDatabaseInPort");
        this.map(sqlFromConnexionMgr,"FromConnexionToDatabase");
        this.map(sqlToDatabase,"FromConnexionToDatabase");
        this.map(sqlFromDatabase,"FromDatabseToConnexion");
        this.map(sqlToConnexionMgr,"FromDatabseToConnexion");
    }
}
