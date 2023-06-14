import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Test {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        // Sadece belirli dosya türlerini seçmek için bir filtre belirleyebilirsiniz
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Resim Dosyaları", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        // Kullanıcıya dosya seçme penceresini göster
        int result = fileChooser.showOpenDialog(null);

        // Kullanıcı dosya seçimi yaptıysa ve Tamam'a tıkladıysa
        if (result == JFileChooser.APPROVE_OPTION) {
            // Seçilen dosyayı alma
            java.io.File secilenDosya = fileChooser.getSelectedFile();

            // Dosya yolunu kullanarak resim dosyasını yükleme
            try {
                java.awt.Image resim = javax.imageio.ImageIO.read(secilenDosya);

                // Resim üzerinde işlemler yapabilirsiniz
                if (resim != null) {
                    // Örneğin, resmin genişliğini ve yüksekliğini alabilirsiniz
                    int genislik = resim.getWidth(null);
                    int yukseklik = resim.getHeight(null);

                    System.out.println("Resim genişliği: " + genislik);
                    System.out.println("Resim yüksekliği: " + yukseklik);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
