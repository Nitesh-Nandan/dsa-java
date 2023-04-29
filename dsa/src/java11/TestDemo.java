package java11;

class Name {
    String name;
    public Name(String name) {
        this.name = name;
    }
}



public class TestDemo {

    private static String getImage512FromImage(String imageUrl) {
        String[] urls = imageUrl.split(",");
        StringBuilder sb = new StringBuilder(convertToImage512(urls[0]));

        for (int i = 1; i < urls.length; i++) {
            sb.append(",");
            sb.append(convertToImage512(urls[i]));
        }

        return sb.toString();
    }

    private static String convertToImage512(String url) {
        return url.replace(".jpg", "") + "_512" + ".jpg";
    }

    public static void main(String[] args) {
        System.out.println(getImage512FromImage("/images/products/49/1.jpg"));
        System.out.println(getImage512FromImage("/images/products/1/1.jpg"));
        System.out.println(getImage512FromImage("/images/products/1/vfwsd.jpg,/images/products/1/olawu.jpg"));

    }

}
