package reader;

import com.google.gson.Gson;
import manager.FileReaderManager;
import model.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "customer.json";
    private List<Customer> customerList;

    public JsonReader() {
        customerList = getCustomerData();
    }

    private List<Customer> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
            return Arrays.asList(customers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        } finally {
            try {
                if (bufferReader != null) bufferReader.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public final Customer getCustomerByName(String customerName) {
        return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
    }
}