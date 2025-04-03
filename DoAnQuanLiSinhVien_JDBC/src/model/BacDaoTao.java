package model;

public enum BacDaoTao {
	CU_NHAN("Cử nhân"),
    THAC_SI("Thạc sĩ"),
    TIEN_SI("Tiến sĩ");

    private final String tenBacDaoTao;

    BacDaoTao(String tenBacDaoTao) {
        this.tenBacDaoTao = tenBacDaoTao;
    }

    public String getTenBacDaoTao() {
        return tenBacDaoTao;
    }
    
    public static BacDaoTao fromString(String tenBacDaoTao) {
        if (tenBacDaoTao != null) {
            for (BacDaoTao bacDaoTao : BacDaoTao.values()) {
                if (tenBacDaoTao.equalsIgnoreCase(bacDaoTao.tenBacDaoTao)) {
                    return bacDaoTao;
                }
            }
        }
        return BacDaoTao.CU_NHAN; // Giá trị mặc định
    }
}
