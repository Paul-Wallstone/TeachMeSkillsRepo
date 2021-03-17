package HW3_2021_03_19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ProductValidator {


    public void validateDebitCard(String numberOfCard1, String typeOfCard1, String name1
            , String surname1, String date1, String cvv1) {
        class DebitCardValidation {
            private String typeOfCard;
            private String cardNumber;
            private String cvv;
            private String name;
            private String surname;
            private String date;

            public DebitCardValidation() {
                this.typeOfCard = typeOfCard1;
                this.cardNumber = numberOfCard1;
                this.name = name1;
                this.surname = surname1;
                this.cvv = cvv1;
                this.date = date1;
            }

            public String getDate() {
                return date;
            }

            public String getCvv() {
                return cvv;
            }

            public String getCardnumber() {
                return cardNumber;
            }

            public String getName() {
                return name;
            }

            public String getTypeOfCard() {
                return typeOfCard;
            }

            public String getSurname() {
                return surname;
            }


            public void printCard() {

                System.out.println("DebitCardValidation{" +
                        "typeOfCard='" + typeOfCard + '\'' +
                        ", cardNumber='" + cardNumber + '\'' +
                        ", cvv='" + cvv + '\'' +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", date='" + date + '\'' +
                        '}');
            }

            public void validateOwner() {
                int key = 0;
                if (getName() == null || getSurname() == null) {
                    System.out.println("Card owner is not validate! Name or surname is not exist.");
                    key = 1;
                }

                String s = getName() + getSurname();
                for (char c : s.toCharArray())
                    if (Character.isDigit(c)) {
                        System.out.println("Card owner is not validate! Digits in name or surname.");
                        key = 2;
                        continue;

                    }
                if (key == 0) {
                    System.out.println("Card owner validation passed!");
                }
            }

            public void validateTypeOfCard() {
                if (getTypeOfCard() == "Debit") {
                    System.out.println("Type of card validation passed!");
                } else {
                    System.out.println("Type of card is not validate! Another type of card.");
                }
            }

            public void validateCardNumber() {
                try {
                    int number = Integer.parseInt(getCardnumber());

                } catch (Exception e) {
                    System.out.println("Card number is not validate because on error occurred: "
                            + e.getMessage());

                }

                if (getCardnumber().length() != 9) {
                    System.out.println("Card number is not validate. Number of digits on card is not 9.");
                } else {
                    System.out.println("Card number validation passed!");
                }
            }

            public void validateCVV() {
                int key = 0;
                if (getCvv().length() != 3) {
                    key = 1;
                    System.out.println("CVV number is not validate. Number of digits on cvv is not 3.");
                }
                for (char c : getCvv().toCharArray()) {
                    if (!Character.isDigit(c)) {
                        key = 2;
                        System.out.println("CVV number is not validate. CVV is not a digit.");
                        break;
                    }
                }
                if (key == 0) {
                    System.out.println("CVV number validation passed!");
                }

            }


            public void validateDate() {
                String strDate = getDate();
                Date date1 = new Date();
                Calendar calendar0 = new GregorianCalendar(2015, 11, 31);
                Calendar calendar2 = new GregorianCalendar(2030, 11, 31);
                Calendar calendar1 = new GregorianCalendar(1950, 0, 1);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
                int key = 0;
                try {
                    date1 = formatter.parse(strDate);

                } catch (ParseException e) {
                    System.out.println("Date is not validate because on error occurred: "
                            + e.getMessage());
                    key = 1;
                }
                if (key == 0) {
                    calendar1.setTime(date1);
                }

                if (calendar1.after(calendar0) && calendar1.before(calendar2)) {
                    System.out.println("Date validation passed!");
                } else {
                    System.out.println("Date validation failed!");
                }

            }
        }

        DebitCardValidation debitCardValidation = new DebitCardValidation();
        debitCardValidation.printCard();
        debitCardValidation.validateCardNumber();
        debitCardValidation.validateOwner();
        debitCardValidation.validateTypeOfCard();
        debitCardValidation.validateCVV();
        debitCardValidation.validateDate();

    }
}