public class NameCountTree {
    private Node root;

    public NameCountTree(){
        root = null;
    }

    public void add(String valueIn){
        if(root == null){
            Pair pair = new Pair(valueIn.toLowerCase());
            Node node = new Node(pair);
            root = node;
        }
        else{
            add(valueIn, root);
        }
    }

    private void add(String valueIn, Node rootTemp){
        if(valueIn.equalsIgnoreCase(rootTemp.data.name)){
            rootTemp.data.count++;
            return;
        }
        if(valueIn.compareToIgnoreCase(rootTemp.data.name) < 0){
            //left - valueIn is smaller than rootTemp
            if(rootTemp.left == null){
                rootTemp.left = new Node(new Pair(valueIn.toLowerCase()));
            }
            else{
                add(valueIn, rootTemp.left);
            }
        }
        else{
            //right - valueIn is larger than rootTemp
            if(rootTemp.right == null){
                rootTemp.right = new Node(new Pair(valueIn.toLowerCase()));
            }
            else{
                add(valueIn, rootTemp.right);
            }
        }
    }

    public void print(){
        if(root != null){
            print(root);
        }
    }

    private void print(Node rootTemp){
        if(rootTemp.left != null){
            print(rootTemp.left);
        }
        System.out.println(rootTemp.data);
        if(rootTemp.right != null){
            print(rootTemp.right);
        }
    }

    public void printMin(){
        if(root != null){
            Node tempNode = root;
            while(tempNode.left != null){
                tempNode = tempNode.left;
            }
            System.out.println(tempNode.data);
        }
    }

    private class Pair{
        public String name;
        public int count;

        public Pair(String nameIn){
            name = nameIn;
            count = 1;
        }

        public String toString(){
            return "(" + name + ", " + count + ")";
        }
    }
    private class Node{
        public Node left;
        public Node right;
        public Pair data;

        public Node(Pair data){
            this.data = data;
            left = null;
            right = null;
        }
    }
}
