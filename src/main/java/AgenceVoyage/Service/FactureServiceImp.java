package AgenceVoyage.Service;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import AgenceVoyage.Model.Facture;
import AgenceVoyage.Model.Offre;
import AgenceVoyage.Model.Reservation;

public class FactureServiceImp implements FactureService {

	private Facture facture;

	public FactureServiceImp(Facture facture) {
		super();
		this.facture = facture;
	}

	@Override
	public void export(HttpServletResponse response) throws DocumentException, IOException {
	   
	       Document document = new Document(PageSize.A4);
	       PdfWriter.getInstance(document, response.getOutputStream());
	       
	       document.open();
	       Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	       font1.setSize(18);
	       Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	       font.setSize(18);
	       font.setColor(Color.GRAY);
	       
	       Image er= Image.getInstance("src/main/resources/static/images/logoFacture.png");
	       er.scaleAbsolute(140, 100);
	       document.add(er);
	       
	       Paragraph h = new Paragraph("Facture De Paiement ", font1);
	       h.setAlignment(Paragraph.ALIGN_CENTER);
	       document.add(h);
	       
	       Paragraph t= new Paragraph("Agence : Safely Travel\n"
	        + "Téléphone : +212 669684132\n"
	        + "Email : touristique2021@gmail.com\n "
	        + "Adresse : Rue 09, Boulvard Andalous\n"
	        + "                  Casablanca\n");
	       document.add(t);
	       
	       
	       DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	       String currentDateTime = dateFormatter.format(new Date());
	     
	       Paragraph C =new Paragraph("Date :"+currentDateTime+"\n"
	        + "Payée par : Mr./Mme "+facture.getUser().getNom()+" "+facture.getUser().getPrenom()+"\n"+"\n");
	       C.setAlignment(Paragraph.ALIGN_RIGHT);
	       document.add(C);
	       
	       
	     
	       Paragraph p = new Paragraph("Votre Reservation\n", font);
	       p.setAlignment(Paragraph.ALIGN_CENTER);
	       p.setSpacingAfter(8);
	       
	       
	       document.add(p);
	       
	     
	   Reservation reservation=facture.getReservation();
	    Offre reservation2=facture.getMonoffre();
	    String villeD;
	    String text;
	    if(reservation2.getVilleDepart()!=null) {
	    	villeD=reservation2.getVilleDepart();
	    }
	    else {
	    	villeD=reservation.getVilleOmra();
	    }
	    if(reservation2.getVilleDepart()!=null && reservation2.getVilleArrive()!=null) {
	        text=" de la ville départ : "+villeD
	               + " vers la distination : "+ reservation2.getVilleArrive();
	       }else
	        text="";
	   
	    Paragraph f = new Paragraph("Cher(Chère) client(e) "+facture.getUser().getNom()+" "+facture.getUser().getPrenom()+",\n"+"\n"+"\n"
	            + "Vous avez effectué une reservation dans notre agence SAFELY TRAVEL le : "+reservation.getDateReservation()+" "+text+" de prix  par personne : "+ reservation2.getPrix() +" dirhams ."+
	            "\n Cette réservation était pour :"+ reservation.getNbrAdulte()+" adulte(s) et : "+ reservation.getNbrEnfant() +" enfant(s).\n"+"\n"
	            + "NB: le prix pour enfant est la moité.\n \n \n \n \n \n \n");
	         
	                document.add(f); 
	               
	                
	                Image im= Image.getInstance("src/main/resources/static/images/signature.jpg");
	                im.scaleAbsolute(140, 100);
	                im.setSpacingBefore(200);
	                im.setAlignment(Image.RIGHT);
	                document.add(im);
	                
	                Paragraph b=new Paragraph("\n \n \n NOUS VOUS REMERCIONS DE VOTRE CONFIANCE.");
	              b.setSpacingAfter(10);
	                document.add(b);
	                
	              document.close();
	              
	          }
	   
}
