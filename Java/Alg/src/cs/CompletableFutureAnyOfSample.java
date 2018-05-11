package cs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

class DownloadUtil {

	public static String download(String url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setDoOutput(false);
		conn.setAllowUserInteraction(false);
		conn.setConnectTimeout(1000);
		conn.setReadTimeout(1000);
		conn.connect();
		ByteArrayOutputStream output = new ByteArrayOutputStream(10240);
		try (InputStream input = conn.getInputStream()) {
			int n;
			byte[] buffer = new byte[2048];
			while ((n = input.read(buffer)) != (-1)) {
				output.write(buffer, 0, n);
			}
		}
		conn.disconnect();
		return new String(output.toByteArray(), "UTF-8");
	}
}
class StockPrice {
	final float price;
	final String from;

	StockPrice(float price, String from) {
		this.price = price;
		this.from = from;
	}

	public String toString() {
		return "Price: " + price + " from " + from;
	}
}

class StockFromSina implements Supplier<StockPrice> {

	@Override
	public StockPrice get() {
		String url = "http://hq.sinajs.cn/list=gb_goog";
		System.out.println("GET: " + url);
		try {
			String result = DownloadUtil.download(url);
			String[] ss = result.split(",");
			return new StockPrice(Float.parseFloat(ss[3]), "sina");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class StockFromNetease implements Supplier<StockPrice> {

	@Override
	public StockPrice get() {
		String url = "http://api.money.netease.com/data/feed/US_GOOG";
		System.out.println("GET: " + url);
		try {
			String result = DownloadUtil.download(url);
			int priceIndex = result.indexOf("\"price\"");
			int start = result.indexOf(":", priceIndex);
			int end = result.indexOf(",", priceIndex);
			return new StockPrice(Float.parseFloat(result.substring(start + 1, end)), "netease");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

public class CompletableFutureAnyOfSample {

	public static void main(String[] args) throws Exception {
		CompletableFuture<StockPrice> getStockFromSina = CompletableFuture.supplyAsync(new StockFromSina());
		CompletableFuture<StockPrice> getStockFromNetease = CompletableFuture.supplyAsync(new StockFromNetease());
		CompletableFuture<Object> getStock = CompletableFuture.anyOf(getStockFromSina, getStockFromNetease);
		getStock.thenAccept(new Consumer<Object>() {
			public void accept(Object result) {
				System.out.println("Reuslt: " + result);
			}
		});
		getStock.join();
	}

}
