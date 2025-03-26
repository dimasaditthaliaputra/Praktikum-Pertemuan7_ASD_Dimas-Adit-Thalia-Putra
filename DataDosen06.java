public class DataDosen06 {
    Dosen06 dataDosen[] = new Dosen06[10];
    int idx;

    void tambah(Dosen06 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("data sudah penuh");
        }
    }

    void tampil() {
        for (Dosen06 dsn : dataDosen) {
            dsn.tampil();
            System.out.println("-------------------------------");
        }
    }

    void sortingASC() {
        for (int i = 0; i < dataDosen.length - 1; i++) {
            for (int j = 1; j < dataDosen.length - i; j++) {
                if (dataDosen[j].usia < dataDosen[j - 1].usia) {
                    Dosen06 tmp = dataDosen[j];
                    dataDosen[j] = dataDosen[j - 1];
                    dataDosen[j - 1] = tmp;
                }
            }
        }
    }

    void sortingDSC() {
        for (int i = 0; i < dataDosen.length; i++) {
            int idxMin = i;
            for (int j = i + 1; j < dataDosen.length; j++) {
                if (dataDosen[j].usia > dataDosen[idxMin].usia) {
                    idxMin = j;
                }
            }
            Dosen06 tmp = dataDosen[idxMin];
            dataDosen[idxMin] = dataDosen[i];
            dataDosen[i] = tmp;
        }
    }

    void pencarianDataSequential06(String cariNama) {
        boolean ditemukan = false;
        int count = 0;

        System.out.println("--------------------------------------");
        System.out.println("Hasil Pencarian untuk Nama: " + cariNama);
        for (int j = 0; j < idx; j++) {
            if (dataDosen[j].nama.equalsIgnoreCase(cariNama)) {
                dataDosen[j].tampil();
                ditemukan = true;
                count++;
                System.out.println("--------------------------------------");
            }
        }

        if (!ditemukan) {
            System.out.println("Dosen dengan nama '" + cariNama + "' tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("Peringatan: Ditemukan lebih dari satu dosen dengan nama '" + cariNama + "' (" + count
                    + " hasil).");
        }
    }

    void pencarianDataBinary06(int cariUsia, int left, int right) {
        int posisi = -1;
        int count = 0;

        if (right >= left) {
            int mid = (left + right) / 2;

            if (dataDosen[mid].usia == cariUsia) {
                posisi = mid;
                count++;

                int i = mid - 1;
                while (i >= left && dataDosen[i].usia == cariUsia) {
                    count++;
                    i--;
                }
                i = mid + 1;
                while (i <= right && dataDosen[i].usia == cariUsia) {
                    count++;
                    i++;
                }
            } else if (dataDosen[mid].usia > cariUsia) {
                pencarianDataBinary06(cariUsia, left, mid - 1);
                return;
            } else {
                pencarianDataBinary06(cariUsia, mid + 1, right);
                return;
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Hasil Pencarian untuk Usia: " + cariUsia);
        boolean ditemukan = false;
        for (int j = 0; j < idx; j++) {
            if (dataDosen[j].usia == cariUsia) {
                dataDosen[j].tampil();
                ditemukan = true;
                System.out.println("--------------------------------------");
            }
        }

        if (!ditemukan) {
            System.out.println("Dosen dengan usia " + cariUsia + " tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("Peringatan: Ditemukan lebih dari satu dosen dengan usia " + cariUsia + " (" + count
                    + " hasil).");
        }
    }
}
