
import java.io.*;


/**
 *
 * @author aakash patel
 */  


class MyDlist extends DList {

    public MyDlist() {
        super();
    }

    public MyDlist(String f) {
        super();

        String[] result = f.split("\\s");

        addToList(result);
    }

	private void addToList(String[] result) {
		DNode node = new DNode(result[0], null, null);
        this.addFirst(node);

        for (int i = 1; i < result.length; i++) {
            DNode nextNode = new DNode(result[i], node, null);
            this.addAfter(node, nextNode);
            node = nextNode;
        }
	}

    public void printList() {
        System.out.println(this.toString());
    }

    public void newPrintList() {
        String s = this.toString();
        String[] result = s.split(",");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static MyDlist cloneList(MyDlist originalList) {
        String[] str = new String[originalList.size];
        
        DNode orgNode = originalList.getFirst();
        str[0] = orgNode.getElement();

        for (int i = 1; i < originalList.size; i++) {
        	orgNode = orgNode.getNext();
        	str[i] = orgNode.getElement();
        }
        
        MyDlist newList = new MyDlist();
        newList.addToList(str);
      return newList;
    }

    public static void main(String args[]) throws Exception {
    	//Read File
        FileReader fileReader = new FileReader("C:\\Users\\aakash patel\\Documents\\NetBeansProjects\\Dnode\\src\\dnode\\StringFile.txt");
        BufferedReader bufferRdr = new BufferedReader(fileReader);
        String wholeFileStr = "";
        String lineStr;
        while ((lineStr = bufferRdr.readLine()) != null) {
            wholeFileStr += lineStr + ' ';
        }

        fileReader.close();
        //Example Empty List
        MyDlist emptyList = new MyDlist();
        emptyList.printList();
        
        //Example with File List
        MyDlist fileList = new MyDlist(wholeFileStr);
        fileList.printList();
        
        //Example print as original
        fileList.newPrintList();
        
        //Clone List 
        MyDlist cloneList = MyDlist.cloneList(fileList);
        cloneList.printList();

    }

}
