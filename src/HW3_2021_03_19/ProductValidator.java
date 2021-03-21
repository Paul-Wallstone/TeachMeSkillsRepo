package HW3_2021_03_19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ProductValidator {


    public void validateDebitCard(String numberOfCard1, String typeOfCard1, String name1,
                                  String surname1, String date1, String cvv1) {
        class DebitCardValidation {
            private String typeOfCard;
            private String cardNumber;
            private String cvv;
            private String name;
            private String surname;
            private String date;
            boolean isCorrect = false;

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
                isCorrect = true;
                if (getName() == null || getSurname() == null) {
                    System.out.println("Card owner is not validate! Name or surname is not exist.");
                    isCorrect = false;
                }
                String s = getName() + getSurname();
                for (char c : s.toCharArray())
                    if (Character.isDigit(c)) {
                        System.out.println("Card owner is not validate! Digits in name or surname.");
                        isCorrect = false;
                        continue;
                    }
                if (isCorrect == true) {
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
                isCorrect = true;
                if (getCvv().length() != 3) {
                    isCorrect = false;
                    System.out.println("CVV number is not validate. Number of digits on cvv is not 3.");
                }
                for (char c : getCvv().toCharArray()) {
                    if (!Character.isDigit(c)) {
                        isCorrect = false;
                        System.out.println("CVV number is not validate. CVV is not a digit.");
                        break;
                    }
                }
                if (isCorrect == true) {
                    System.out.println("CVV number validation passed!");
                }
            }

            public void validateDate() {
                String strDate = getDate();
                LocalDate localDate = LocalDate.now();
                LocalDate localDate1 = LocalDate.of(2015, 12, 31);
                LocalDate localDate2 = LocalDate.of(2030, 12, 31);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                isCorrect = true;
                try {
                    localDate = LocalDate.parse(strDate, dateTimeFormatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Date is not validate because on error occurred: "
                            + e.getMessage());
                    isCorrect = false;
                }
                if (localDate.isAfter(localDate1) && localDate.isBefore(localDate2) && isCorrect == true) {
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