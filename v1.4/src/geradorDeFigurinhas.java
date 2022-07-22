import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.Font;


public class geradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

        // leitura da imagem
        // InputStream InputStream = new FileInputStream(new File("./v1.2/entrada/filme.jpg")); LOCAL
       // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_3.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem com transparência e tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original para a nova imagem

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte da nova imagem

        var fonte = new Font("ComicSans", Font.BOLD, 112);
        graphics.setFont(fonte);
        graphics.setColor(java.awt.Color.RED);
        // escrever texto na nova imagem

        Graphics2D escrita = graphics;
        escrita.drawString("TOP", novaAltura/largura, novaAltura - 100);


        //escrever a nova imagem em um arquivo
        /*
         * write to temporary file with thread-id suffix
         * File tempFile =
         * new File(destinationDirectory + fileName + Thread.currentThread().getId() +
         * ".t");
         * ImageIO.write(bufferedImage, 'jpg', tempFile);
         * // rename into place
         * tempFile.rename(new File(fileName));
         */ 
        File temporario = new File("./saida/" + nomeArquivo);
        temporario.mkdirs();
        ImageIO.write(novaImagem, "png", temporario);
        temporario.renameTo(new File(".saida/", nomeArquivo));


        


    }
}
