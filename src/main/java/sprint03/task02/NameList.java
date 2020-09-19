package sprint03.task02;

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter;

        private Iterator() {
        }

        public boolean hasNext() {
            return counter < names.length;
        }

        public String next() {
            if (this.hasNext()) {
                return names[counter++];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        NameList nameList = new NameList();
        for (Iterator iter = nameList.getIterator(); iter.hasNext(); ) {
            String name = iter.next();
            System.out.println("Name : " + name);
        }
    }
}

