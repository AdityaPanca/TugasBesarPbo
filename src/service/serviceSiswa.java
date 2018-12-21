
package service;

import entity.siswa;
import java.util.List;

public interface serviceSiswa {
    void insertSiswa(siswa sis);
    void updateSiswa(siswa sis);
    void deleteSiswa(siswa sis);
    siswa getByid(String id);
    List<siswa> getsisSiswa();
}
