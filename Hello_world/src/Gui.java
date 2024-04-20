import javax.swing.JOptionPane;

// The import java.lang.Double is not needed, so it can be removed


public interface Gui {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(" Enter your name ");
        JOptionPane.showMessageDialog(null, "Hello "+name);
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        JOptionPane.showMessageDialog(null,
                new StringBuilder().append("you are ").append(age).append(" Year old ").toString());
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height Bro "));
        JOptionPane.showMessageDialog(null, " your height is "+ height);

    }

}
