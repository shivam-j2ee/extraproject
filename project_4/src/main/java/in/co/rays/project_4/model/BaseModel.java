package in.co.rays.project_4.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import in.co.rays.project_4.bean.DropdownListBean;
import in.co.rays.project_4.exception.ApplicationException;
import in.co.rays.project_4.exception.DatabaseException;
import in.co.rays.project_4.utility.DataUtility;
import in.co.rays.project_4.utility.JdbcDataSource;

public abstract class BaseModel implements Serializable,DropdownListBean,Comparable<BaseModel>{

	  private static Logger log = Logger.getLogger(BaseModel.class);

	    /**
	     * Non Business primary key
	     */
	    protected long id;

	    /**
	     * User name that creates this record.
	     */
	    protected String createdBy;

	    /**
	     * User name that modifies this record.
	     */
	    protected String modifiedBy;

	    /**
	     * Created timestamp of record
	     */
	    protected java.sql.Timestamp createdDatetime;

	    /**
	     * Modified timestamp of record
	     */
	    protected java.sql.Timestamp modifiedDatetime;

	    /**
	     * accessor methods
	     */
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public java.sql.Timestamp getCreatedDatetime() {
	        return createdDatetime;
	    }

	    public void setCreatedDatetime(java.sql.Timestamp timestamp) {
	        this.createdDatetime = timestamp;
	    }

	    public java.sql.Timestamp getModifiedDatetime() {
	        return modifiedDatetime;
	    }

	    public void setModifiedDatetime(java.sql.Timestamp timestamp) {
	        this.modifiedDatetime = timestamp;
	    }

	    public String getCreatedBy() {
	        return createdBy;
	    }

	    public void setCreatedBy(String createdBy) {
	        this.createdBy = createdBy;
	    }

	    public String getModifiedBy() {
	        return modifiedBy;
	    }

	    public void setModifiedBy(String modifiedBy) {
	        this.modifiedBy = modifiedBy;
	    }

	    /**
	     * Compares IDs ( Primary Key). If keys are equals then objects are equals.
	     *
	     */
	    public int compareTo(BaseModel next) {
	        return (int) (id - next.getId());
	    }

	    /**
	     * created next PK of record
	     *
	     * @throws DatabaseException
	     */

	    public long nextPK() throws DatabaseException {
	        log.debug("Model nextPK Started");
	        Connection conn = null;
	        long pk = 0;
	        try {
	            conn = JdbcDataSource.getConnection();
	            PreparedStatement pstmt = conn
	                    .prepareStatement("SELECT MAX(ID) FROM " + getTableName());
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                pk = rs.getInt(1);
	            }
	            rs.close();
	        } catch (Exception e) {
	            log.error("Database Exception..", e);
	            throw new DatabaseException("Exception : Exception in getting PK");
	        } finally {
	        	
				JdbcDataSource.closeConnection(conn);
	        }
	        log.debug("Model nextPK End");
	        return pk + 1;
	    }

	    /**
	     * Gets table name of Model
	     *
	     * @return
	     */
	    public abstract String getTableName();

	    /**
	     * Updates created by info
	     *
	     * @throws ApplicationException
	     *
	     * @throws Exception
	     */
	    public void updateCreatedInfo() throws ApplicationException {

	        log.debug("Model update Started..." + createdBy);

	        Connection conn = null;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;
	        String sql = "UPDATE " + getTableName()
	                + " SET CREATED_BY=?, CREATED_DATETIME=? WHERE ID=?";
	        log.debug(sql);

	        try {
	            conn = JdbcDataSource.getConnection();
	            conn.setAutoCommit(false); // Begin transaction
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, createdBy);
	            pstmt.setTimestamp(2, DataUtility.getCurrentTimeStamp());
	            pstmt.setLong(3, id);

	            pstmt.executeUpdate();
	            conn.commit(); // End transaction
	            pstmt.close();
	        } catch (SQLException e) {
	            log.error("Database Exception..", e);
	            //JdbcDataSource.trnRollback(conn);
	           // throw new ApplicationException(e.toString());
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            
				JdbcDataSource.closeConnection(conn);
	        }
	        log.debug("Model update End");
	    }

	    /**
	     * Updates modified by info
	     *
	     * @param model
	     * @throws Exception
	     */
	    public void updateModifiedInfo() throws Exception {

	        log.debug("Model update Started");
	        Connection conn = null;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;

	        String sql = "UPDATE " + getTableName()
	                + " SET MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?";

	        try {
	            conn = JdbcDataSource.getConnection();
	            conn.setAutoCommit(false); // Begin transaction
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, modifiedBy);
	            pstmt.setTimestamp(2, DataUtility.getCurrentTimeStamp());
	            pstmt.setLong(3, id);
	            pstmt.executeUpdate();
	            conn.commit(); // End transaction
	            pstmt.close();
	        } catch (SQLException e) {
	            log.error("Database Exception..", e);
	            JdbcDataSource.trnRollback(conn);
	        } finally {
	        	
				JdbcDataSource.closeConnection(conn);
	        }
	        log.debug("Model update End");
	    }

	    /**
	     * Populate Model from ResultSet
	     *
	     * @param model
	     * @param rs
	     * @return
	     */
	    protected <T extends BaseModel> T populateModel(T model, ResultSet rs)
	            throws SQLException {
	        model.setId(rs.getLong("ID"));
	        model.setCreatedBy(rs.getString("CREATED_BY"));
	        model.setModifiedBy(rs.getString("MODIFIED_BY"));
	        model.setCreatedDatetime(rs.getTimestamp("CREATED_DATETIME"));
	        model.setModifiedDatetime(rs.getTimestamp("MODIFIED_DATETIME"));
	        return model;
	    }
	


	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
