package AgenceVoyage.Service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

public interface FactureService {
	void export(HttpServletResponse response)throws DocumentException, IOException;
}
