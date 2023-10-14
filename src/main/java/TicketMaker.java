
import com.google.zxing.WriterException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author reckless
 */
public class TicketMaker {

    private BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void doIt(UUID uuid, String type,String additional) {
        String text = "Q12 Party";

        try {

//            BufferedImage img = ImageIO.read(new File("/home/reckless/Downloads/Test/TicketM.png"));
            BufferedImage img = ImageIO.read(new File("Ticket.png"));
            byte[] qrCodeImageArray = QRCodeGenerator.getQRCodeImageArray(uuid.toString());
            BufferedImage qr = createImageFromBytes(qrCodeImageArray);

            int width = img.getWidth();
            int height = img.getHeight();

            // System.out.println(width + " " + height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = bufferedImage.createGraphics();
            Font ticket = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("ticketing.regular.ttf"));

            ticket.deriveFont(Font.PLAIN,120);

            Font font = new Font("Ticketing", Font.PLAIN, 120);


            System.out.println(ticket);
            System.out.println(ticket);


            g2d.setFont(font);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawImage(img, 0, 0, null);

            g2d.drawImage(qr, 4350, 900, null);

          //  g2d.drawString(text, 1800, 400);
            g2d.drawString("Ticket", 1550, 400);
            g2d.drawString(uuid.toString(), 1550, 800);
            g2d.drawString(type, 1550, 1100);
            g2d.drawString(additional, 1550, 1400);
            g2d.dispose();

            File file = new File("C:/Users/Nico/Downloads/" + uuid.toString());
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(TicketMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    void doIt4x(String type,String additional) {
        String text = "Q12 Party";

        try {

//            BufferedImage img = ImageIO.read(new File("/home/reckless/Downloads/Test/TicketM.png"));
            BufferedImage img = ImageIO.read(new File("4Tickets.png"));


            int width = img.getWidth();
            int height = img.getHeight();

            // System.out.println(width + " " + height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = bufferedImage.createGraphics();
            Font ticket = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("ticketing.regular.ttf"));

            ticket.deriveFont(Font.PLAIN,120);

            Font font = new Font("Ticketing", Font.PLAIN, 120);


            System.out.println(ticket);
            System.out.println(ticket);


            g2d.setFont(font);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawImage(img, 0, 0, null);


            //  g2d.drawString(text, 1800, 400);
            //Ticket 1
            UUID uuid1 = UUID.randomUUID();
            byte[] qrCodeImageArray1 = QRCodeGenerator.getQRCodeImageArray(uuid1.toString());
            BufferedImage qr1 = createImageFromBytes(qrCodeImageArray1);

            g2d.drawImage(qr1, 4350, 900, null);

            g2d.drawString("Ticket", 1550, 400);
            g2d.drawString(uuid1.toString(), 1550, 800);
            g2d.drawString(type, 1550, 1100);
            g2d.drawString(additional, 1550, 1400);

            //Ticket 2 (+2126)
            UUID uuid2 = UUID.randomUUID();
            byte[] qrCodeImageArray2 = QRCodeGenerator.getQRCodeImageArray(uuid2.toString());
            BufferedImage qr2 = createImageFromBytes(qrCodeImageArray2);

            g2d.drawImage(qr2, 4350, 900+2126, null);

            g2d.drawString("Ticket", 1550, 400+2126);
            g2d.drawString(uuid2.toString(), 1550, 800+2126);
            g2d.drawString(type, 1550, 1100+2126);
            g2d.drawString(additional, 1550, 1400+2126);

            //Ticket 3 (+4252)
            UUID uuid3 = UUID.randomUUID();
            byte[] qrCodeImageArray3 = QRCodeGenerator.getQRCodeImageArray(uuid3.toString());
            BufferedImage qr3 = createImageFromBytes(qrCodeImageArray3);

            g2d.drawImage(qr3, 4350, 900+4252, null);

            g2d.drawString("Ticket", 1550, 400+4252);
            g2d.drawString(uuid3.toString(), 1550, 800+4252);
            g2d.drawString(type, 1550, 1100+4252);
            g2d.drawString(additional, 1550, 1400+4252);

            //Ticket 4 (+6378)
            UUID uuid4 = UUID.randomUUID();
            byte[] qrCodeImageArray4 = QRCodeGenerator.getQRCodeImageArray(uuid4.toString());
            BufferedImage qr4 = createImageFromBytes(qrCodeImageArray4);

            g2d.drawImage(qr4, 4350, 900+6378, null);

            g2d.drawString("Ticket", 1550, 400+6378);
            g2d.drawString(uuid4.toString(), 1550, 800+6378);
            g2d.drawString(type, 1550, 1100+6378);
            g2d.drawString(additional, 1550, 1400+6378);

            g2d.dispose();

            File file = new File("C:/Users/Nico/Downloads/" + "#"+userInterface.getSheetsdone()+"--"+ uuid1.toString());
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(TicketMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

}
