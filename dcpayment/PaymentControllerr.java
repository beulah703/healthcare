package spring.orm.controller;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class PaymentControllerr {
	@Autowired
	HttpSession httpSession;

	@RequestMapping(value = "/dcadmin/testpayment", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String pay(String billid, String amount, String currency, Model model)
			throws RazorpayException, JSONException {
		System.out.println(billid + amount + currency);
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_j9AU4Na98kCuvD", "OjyDABQUyWEfafePUqBlqILA");
		JSONObject options = new JSONObject();
		int amt = Integer.parseInt(amount) * 100;
		options.put("amount", amt); // Amount in paise (e.g., 1000 paise = Rs 10)
		options.put("currency", "INR");
		billid= billid + System.currentTimeMillis();
		options.put("receipt", billid);
		Order order = razorpayClient.orders.create(options);
		httpSession.setAttribute("ticketNumber", billid);
		System.out.println(order);
		return order.toString();
	}

}