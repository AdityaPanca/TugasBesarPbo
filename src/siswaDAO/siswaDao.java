
package siswaDAO;

import config.koneksi;
import entity.siswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import service.serviceSiswa;

public class siswaDao implements serviceSiswa{

    private Connection connection;
    
    public siswaDao(){
        connection = koneksi.getConnection();
    }
    
    @Override
    public void insertSiswa(siswa sis) {
        PreparedStatement st = null;
        String sql = "insert into siswa value (?, ?, ?, ?, ?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, sis.getNis());
            st.setString(2, sis.getNama());
            st.setString(3, sis.getJenis());
            st.setString(4, sis.getKelas());
            st.setString(5, sis.getAlamat());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void updateSiswa(siswa sis) {
        PreparedStatement st = null;
        String sql = "update siswa set nama=?, kelamin=?, kelas=?, alamat=? where nis=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, sis.getNama());
            st.setString(2, sis.getJenis());
            st.setString(3, sis.getKelas());
            st.setString(4, sis.getAlamat());
            st.setString(5, sis.getNis());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteSiswa(siswa sis) {
        PreparedStatement st = null;
        String sql = "delete from siswa where nis=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, sis.getNis());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public siswa getByid(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        siswa s = null;
        String sql = "select * from siswa where nis=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs= st.executeQuery();
            while (rs.next()) {
                s = new siswa();
                s.setNis(rs.getString("nis"));
                s.setNama(rs.getString("nama"));
                s.setJenis(rs.getString("kelamin"));
                s.setKelas(rs.getString("kelas"));
                s.setAlamat(rs.getString("alamat"));
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<siswa> getsisSiswa() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="select * from siswa";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                siswa s = new siswa();
                s.setNis(rs.getString("nis"));
                s.setNama(rs.getString("nama"));
                s.setJenis(rs.getString("kelamin"));
                s.setKelas(rs.getString("kelas"));
                s.setAlamat(rs.getString("alamat"));
                list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(siswaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
