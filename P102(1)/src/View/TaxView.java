package View;

import Common.Library;
import Common.Validation;
import DAO.IncomeTaxDao;
import java.util.List;
import model.Children;
import model.Parent;
import model.Person;
//Deduction for supporting children sai >18 kh co vie
//Doan nhap 
public class TaxView {

    Validation vd = new Validation();
    Library inputStr = new Library();
    IncomeTaxDao itd = new IncomeTaxDao();
    public void displayMess(String mess) {
        System.out.println(mess);
    }

    public void displayMessInput(String mess) {
        System.out.print(mess);
    }
Person person = new Person();
    public Person inputData(List<Children> childrens, List<Parent> parents) {
        
        System.out.println("---------Input Person Data----------");
        String name = "Thien";
        //String name = inputStr.inputString("Enter Name: ");
        if (!vd.checkName(name)) {
            return null;
        }
        person.setName(name);
        
        String age ="30";
        //String age = inputStr.inputString("Enter Age: ");
        if (!vd.checkInt(age, 1, 122)) {
            return null;
        }
        person.setAge(Integer.parseInt(age));
        
        String sex = "1";
        //String sex = inputStr.inputString("Enter sex( 1:male || 0:female ): ");
        if (!vd.checkInt(sex, 0, 1)) {
            return null;
        }
        person.setIsSex(Integer.parseInt(sex));
        
        String income = "30000000";
        //String income = inputStr.inputString("Enter Income: ");
        if (!vd.checkDouble(income, 0)) {
            return null;
        }
        person.setIncome(Double.parseDouble(income));
        
        String child = "2";
        //String child = inputStr.inputString("Enter number of children: ");
        if (!vd.checkInt(child, 0, 15)) {
            return null;
        }
        person.setHasChild(Integer.parseInt(child));
        
        
        String parent = "2";
        //String parent = inputStr.inputString("Enter number of parent: ");
        if (!vd.checkInt(parent, 0, 15)) {
            return null;
        }
        person.setHasParent(Integer.parseInt(parent));
        
        
        String SR = "1";
        //String SR = inputStr.inputString("Is that person have sibling register ?( 1:yes || 0:no): ");
        if (!vd.checkInt(SR, 0, 1)) {
            return null;
        }
        person.setHasSiblingRegister(Integer.parseInt(SR));
        
        int numSib = 3;
        //int numSib = inputStr.checkPositiveNum("Enter numbers of sibling: ");
        person.setNumSib(numSib);
       

        if (person.getHasChild() > 0) {
            System.out.println("--------Input Children Data---------");
            inputChilren(childrens, person.getHasChild());
        }
        if (person.getHasParent() > 0) {
            System.out.println("--------Input Parent Data ----------");
            inputParent(parents, person.getHasParent());
        }
        person.setDeduction(11000000);
        return person;
    }

    public Children inputChilren(List<Children> childrens, int hasChild) {
        Children children = new Children();
        for (int i = 0; i < hasChild; i++) {
            System.out.println("Input Child No." + (i + 1));
            //String ageChild = "16";
            String ageChild = inputStr.inputString("Enter Age :");
            if (!vd.checkInt(ageChild, 0, 122)) {
                return null;
            }
            children.setAge(Integer.parseInt(ageChild));
            //String studying = "1";
            String studying = inputStr.inputString("Is child studying ?( 1:yes || 0:no): ");
            if (!vd.checkInt(studying, 0, 1)) {
                return null;
            }
            children.setIsStudying(Integer.parseInt(studying));
            childrens.add(children);
        }
        return children;
    }

    public Parent inputParent(List<Parent> parents, int hasParent) {
        Parent parent = new Parent();
        for (int i = 0; i < hasParent; i++) {
            System.out.println("Input Parent No." + (i + 1));
            //String ageParent = "65";
            String ageParent = inputStr.inputString("Enter Age :");
            if (!vd.checkInt(ageParent, 0, 122)) {
                return null;
            }
            parent.setAge(Integer.parseInt(ageParent));
            //String isSex = "1";
            String isSex = inputStr.inputString("Enter sex( 1:male || 0:female): ");
            if (!vd.checkInt(isSex, 0, 1)) {
                return null;
            }
            parent.setIsSex(Integer.parseInt(isSex));
            parents.add(parent);
        }
        return parent;
    }
    public void detailOfDeduction(List<Children> childrens, List<Parent> parents){
        System.out.println("--------Detail Of Deduction-------");
        double income = person.getIncome();
        System.out.printf("Total Income: %.2f\n",income);
        
        System.out.println("Deduction for self: " + person.getDeduction());
        
        System.out.print("Deduction for supporting children: ");
        int deduction_for_children = itd.deductionForChildrens(childrens);
        System.out.println(deduction_for_children);
        
        System.out.print("Deduction for supporting parents: ");
        int deduction_for_parents = itd.deductionForParents(person, parents,person.getNumSib());
        System.out.println(deduction_for_parents);
        
        System.out.print("Deduction total: ");
        int deduction = itd.deductionTotal(deduction_for_children, deduction_for_parents);
        System.out.println(deduction);
        
        System.out.print("Income Taxs: ");
        double Incometax = itd.calculateIncomeTax(income, deduction);
        System.out.printf("%.2f\n", Incometax);
        
        double incomeTax = itd.calculatePaid(income, deduction);
        System.out.printf("-------------\nThe amount of tax to be paid: %.2f\n",incomeTax);
    }
}


