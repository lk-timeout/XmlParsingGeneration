
import javax.xml.bind.JAXBException;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestXml {

	private static final String XML_PATH_COUNTRY = "./Country.xml";
	private static final String XML_PATH_COUNTRIES = "./Countries.xml";

	public static void main(String[] args) throws JAXBException {
		Country china = new Country();
		china.setName("中国");
		china.setCapital("北京");
		china.setPopulation(1400000000);
		china.setRank(25);
		String fTimeChina = LocalDate.of(1949, 10, 1).toString();
		china.setFoundationTime(fTimeChina);

		Country america = new Country();
		america.setName("United States of America");
		america.setCapital("new York");
		america.setPopulation(300000000);
		america.setRank(11);
		String fTimeAmerica = LocalDate.of(1776, 7, 4).toString();
		america.setFoundationTime(fTimeAmerica);

		File xmlFile = new File(XML_PATH_COUNTRY);
		File xmlFile1 = new File(XML_PATH_COUNTRIES);

		System.out.println("\n【写入到" + XML_PATH_COUNTRY + "】");
		JAXBUtils.writeXML(china, xmlFile, Country.class);

		System.out.println("\n【写入list到" + XML_PATH_COUNTRIES + "】");
		Countries countries = new Countries();
		ArrayList<Country> list = new ArrayList<>();
		list.add(china);
		list.add(america);
		countries.setCountries(list);
		JAXBUtils.writeXML(countries, xmlFile1, Countries.class);

		System.out.println("\n【从" + XML_PATH_COUNTRIES + "中读取】");
		Countries countriesRead = (Countries) JAXBUtils.readXML(xmlFile1, Countries.class, Country.class);
		System.out.println(countriesRead);

		System.out.println("\n【从" + XML_PATH_COUNTRY + "中读取】");
		Country countryRead = (Country) JAXBUtils.readXML(xmlFile, Country.class);
		System.out.println(countryRead);
	}
}