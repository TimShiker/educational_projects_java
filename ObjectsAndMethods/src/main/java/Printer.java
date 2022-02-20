public class Printer {

    private String queue;
    private int pagesCount = 0;
    private int documentsCount = 0;

    private static int totalDocumentsCount = 0;
    private static int totalPagesCount = 0;
    private static int totalDocumentsAndPagesCount = 0;

    public Printer(){
        queue = "List of documents to print:" + "\n";
    }

    // created overload methods 'append'
    public void append(String text){
        append(text, "", 0);
    }

    public void append(String text, String name){
        append(text, name, 0);
    }

    public void append(String text, int countOfPages){
        append(text, "", countOfPages);
    }

    public void append(String text, String name, int countOfPages){
        queue = queue +
                "\t\nText of the document: " + "\"" + text + "\"" +
                "\t\nName of the document: " + "\"" + name + "\"" +
                "\t\nCount of pages: " + countOfPages + "\n";
        documentsCount = documentsCount + 1;
        pagesCount = pagesCount + countOfPages;
    }

    public void clear(){
        queue = "";
        documentsCount = 0;
        pagesCount = 0;
    }

    public void print(String title){
        System.out.println(title + "\n");
        if(queue.isEmpty()){
            System.out.println("No documents to print.");
        }
        else {
            System.out.println(queue);

            totalDocumentsCount = totalDocumentsCount + documentsCount;
            totalPagesCount = totalPagesCount + pagesCount;

            totalDocumentsAndPagesCount = totalDocumentsCount + totalPagesCount;
        }

        clear();
    }

    public int getPagesCount(){
        return pagesCount;
    }

    public int getDocumentsCount(){
        return documentsCount;
    }

    // created static method
    public static int getTotalPrintDocumentsAndPages(){
        return totalDocumentsAndPagesCount;
    }
}
