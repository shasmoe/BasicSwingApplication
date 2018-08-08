package connection;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
public class db_connection {
private static db_connection datasource;
private BoneCP connectionPool;
private db_connection() throws IOException, SQLException, PropertyVetoException {
        try {
            //load the database driver (make sure this is in your classpath!)
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         try{
            BoneCPConfig config = new BoneCPConfig();
            
            //local connection
            config.setJdbcUrl("jdbc:mysql://localhost/basic");
            config.setUsername("roots");
            config.setPassword("Basic@18");
            config.setMinConnectionsPerPartition(5);
            config.setMaxConnectionsPerPartition(300);
            config.setPartitionCount(2);
            config.setDefaultAutoCommit(true);
            config.setIdleConnectionTestPeriodInMinutes(10);
            config.setConnectionTestStatement("/* ping */ SELECT 1");
            config.setAcquireIncrement(3);
            config.setLazyInit(true);
            connectionPool = new BoneCP(config);
        }catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            //new problemswindows().setVisible(true);
        }
    }

    public static db_connection getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new db_connection();
            
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.connectionPool.getConnection();
    }
    
}
