package com.baeldung.jaxws.server.topdown.main;

import java.io.InputStream;
import java.util.List;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import com.baeldung.jaxws.server.topdown.BookService;
import com.baeldung.jaxws.server.topdown.GetAllBooksResponse;
import com.baeldung.jaxws.server.topdown.GetAllBooksResponse.Book;
import com.baeldung.jaxws.server.topdown.ObjectFactory;

@WebService(name = "BookService", targetNamespace = "http://www.cleverbuilder.com/BookService/")
@XmlSeeAlso({ ObjectFactory.class })
public class BookServiceImpl implements BookService {

	@Override
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public void getBook(Holder<String> id, Holder<String> title, Holder<String> author) {

	}

	@Override
	public String addBook(String title, String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "Book", targetNamespace = "")
	public List<Book> getAllBooks() {

		GetAllBooksResponse response = null;

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(GetAllBooksResponse.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			InputStream fis = BookServiceImpl.class.getClassLoader().getResourceAsStream("response.xml");

			response = (GetAllBooksResponse) jaxbUnmarshaller.unmarshal(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response.getBook();
	}

}
