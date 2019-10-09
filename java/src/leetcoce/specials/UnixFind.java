package leetcoce.specials;

import java.io.File;

public class UnixFind {
    public static void main(String[] args) {
        UnixFind unixFind = new UnixFind();
        unixFind.search(new File("."), "UnixFind.java");
    }

    public void search(File file, String name) {
        if (null == file) {
            return;
        }

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                search(f, name);
            }
        } else {
            if (file.getName().equals(name)) {
                System.out.println("File found: " + file.getName() + " at " + file.getAbsolutePath());
                return;
            }
        }
    }
}
