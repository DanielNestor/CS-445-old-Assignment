package infiniteinteger;


public class InfiniteInteger implements Comparable<InfiniteInteger>
{
	// TO DO: Instance Variables
	// Note that it is a good idea to declare them final to
	// prevent you from accidentally modify them.
	  boolean isNegative = false;
         int[] storageArray;
	/**
	 * Constructor: Constructs this infinite integer from a string
	 * representing an integer.
	 * @param s  a string represents an integer
	 */
       
	public InfiniteInteger(String s)
	{
            
                int count = 0;
                int arrCount = 0;
                
             
                
              if(s.length() != 0){  
		if(s.charAt(0) == '-'){ 
                    s = s.substring(1, s.length());
                    
                    if(s.length() != 1){
                    s = removeZeros(s);
                    }
                    
                    
                    
                    storageArray = new int[s.length()];
                    count++;
                    isNegative = true;
                }
                else{
                    if(s.length() != 1){
                    s = removeZeros(s);
                    } 
                    storageArray = new int[s.length()];
                }
              }
                
                
                count = 0;
                while(count < s.length() && arrCount < s.length()+1){
                    storageArray[arrCount] = s.charAt(count)-48;
                    count++;
                    arrCount++;
                }
              
              
                
	}

	/**
	 * Constructor: Constructs this infinite integer from an integer.
	 * @param anInteger  an integer
	 */
	public InfiniteInteger(int anInteger)
	{
           
            //convert if needed to positive
		if(anInteger < 0){
                    anInteger = anInteger * -1;
                    isNegative = true;
                }
               
            
                String hold = "" + anInteger;
                
                //repeat code from above
                int count = 0;
                int arrCount = 0;
                storageArray = new int[hold.length()];
                
                
                while(count < hold.length()){
                    storageArray[arrCount] = hold.charAt(count)-48;
                    count++;
                    arrCount++;
                }
            
                
	}
	
	/**
	 * Gets the number of digits of this infinite integer.
	 * @return an integer representing the number of digits
	 * of this infinite integer.
	 */
	public int getNumberOfDigits()
	{           
		return storageArray.length;
	}

	/**
	 * Checks whether this infinite integer is a negative number.
	 * @return true if this infinite integer is a negative number.
	 * Otherwise, return false.
	 */
	public boolean isNegative()
	{
		return isNegative;
	}

	/**
	 * Calculates the result of this infinite integer plus anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to be added to this
	 * infinite integer.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer plus anInfiniteInteger
	 */
	public InfiniteInteger plus(final InfiniteInteger anInfiniteInteger)
	{   
            int count = 1;
            String outputString = "";
            
            
            //taking care of the 0 case
                if(this.toString().equals("0")){
                    
                    return anInfiniteInteger;
                }
                if(anInfiniteInteger.toString().equals("0")){
                    
                    return this;
                    
                }
                
                //declare variables
                String a = this.toString();
                String b = anInfiniteInteger.toString();
                String absValA = getAbsoluteValue(this).toString();
                String absValB = getAbsoluteValue(anInfiniteInteger).toString();
                
                a = removeNegative(a);
                b = removeNegative(b);
                
                
                //adds 0s to even out string
                while(a.length() != b.length()){
                    if(a.length() > b.length()){
                        b = "0" + b;
                    }
                    if(a.length() < b.length()){
                        a = "0" + a;
                    }
                }
               
              //both positive or both negative case
              if((this.isNegative() == true && anInfiniteInteger.isNegative()== true) ||(this.isNegative() == false && anInfiniteInteger.isNegative()== false) ){
                int carry = 0;
                while(count < a.length()+1){
                    int intA = a.charAt(a.length()-count)-48;
                    int intB = b.charAt(b.length()-count)-48;
                    int tempSum = intA + intB + carry;
                    
                    if(tempSum >= 10){
                        tempSum = tempSum - 10;
                        carry = 1;
                    }
                    else{
                        carry = 0;
                    }
                    outputString = tempSum + outputString;
                    count++;
                }
                outputString = carry + outputString;
                
                if(this.isNegative() == true){
                    outputString = "-" + outputString;
                }
              }
              
          
              
              //one positive one negative case
        if((this.isNegative() == true && anInfiniteInteger.isNegative()== false) ||(this.isNegative() == false && anInfiniteInteger.isNegative()== true) ){
            
            //variable declarations
                int carry = 0;
                count = 1;
                boolean addNegative = false;
                
                //even out the strings again
                //adds 0s to even out string
                while(absValA.length() != absValB.length()){
                    if(absValA.length() > absValB.length()){
                        absValB = "0" + absValB;
                    }
                    if(absValA.length() < absValB.length()){
                        absValA = "0" + absValA;
                    }
                }
                
                //declaring needed variables for loop
                int intA = 0,intB = 0;
                int tempDiff = 0;
                int borrow = 0;
                
                
                while(count < absValA.length()+1){
                    
                    
                    
                    if(getAbsoluteValue(this).compareTo(getAbsoluteValue(anInfiniteInteger))== 1 ){
                     intA = absValA.charAt(absValA.length()-count)-48;
                     intB = absValB.charAt(absValB.length()-count)-48;
                     
                     if(this.isNegative() == true){
                         addNegative = true;
                     }
                     
                    }
                    
                    if(getAbsoluteValue(this).compareTo(getAbsoluteValue(anInfiniteInteger)) == -1 ){
                     intA = absValB.charAt(absValB.length()-count)-48;
                     intB = absValA.charAt(absValA.length()-count)-48;
                     
                     if(anInfiniteInteger.isNegative() == true){
                         addNegative = true;
                     }
                     
                    }
                    
                    if(getAbsoluteValue(this).compareTo(getAbsoluteValue(anInfiniteInteger)) == 0 ){
                        InfiniteInteger sum = new InfiniteInteger("0");
                        return sum;
                    }
                    
                    
                    
                    intA = intA + borrow;
                    
                    if(intA < intB){
                        borrow = -1;
                        intA = intA + 10;
                    }
                    else{
                        borrow = 0;
                    }
                    
                    tempDiff = intA - intB;
                    outputString = tempDiff + outputString;
                    count++;
                  
                }
                
                if(addNegative == true){
                    outputString = "-" + outputString;
                }
                
               
                
              }
                
                 
              InfiniteInteger sum = new InfiniteInteger(outputString);
              
              
              
              return sum;
                
	}

	/**
	 * Calculates the result of this infinite integer subtracted by anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to subtract.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer subtracted by anInfiniteInteger
	 */
	public InfiniteInteger minus(final InfiniteInteger anInfiniteInteger)
	{
                InfiniteInteger temp = new InfiniteInteger(anInfiniteInteger.toString());
                temp = changeSign(temp);                
		return this.plus(temp);
	}

	/**
	 * Calculates the result of this infinite integer multiplied by anInfiniteInteger
	 * @param anInfiniteInteger the multiplier.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer multiplied by anInfiniteInteger.
	 */
	public InfiniteInteger multiply(final InfiniteInteger anInfiniteInteger)
	{
           String a = getAbsoluteValue(this).toString();
           String b = getAbsoluteValue(anInfiniteInteger).toString();
           String output = "";
           String temporaryAnswer = "";
           String extraZeros = "";
           int tempProduct = 0;
           int carry = 0;
           int intA = 0;
           int intB = 0;
           
           InfiniteInteger total = new InfiniteInteger("0");
           InfiniteInteger hold;
           
           
           
          //swaping if b is larger
           if(a.length() < b.length()){
               String temp = a;
               a = b;
               b = temp;
           }
           
         
           
           
           //adds 0s to even out string
                while(a.length() != b.length()){
                    if(a.length() > b.length()){
                        b = "0" + b;
                    }
                    if(a.length() < b.length()){
                        a = "0" + a;
                    }
                }
                
            //fixing for how large the value is and swapping after zeros
            // are added
                
            if(a.charAt(0) < b.charAt(0)){
               String temp = a;
               a = b;
               b = temp;
           }
           
           
           //declare parcing variables;
           int parceA = a.length()-1;
           int parceB = b.length()-1;
           
           //running through both numbers(outer loop a: inner loop b)
           while(parceA >= 0){
               
                intA = a.charAt(parceA)-48;
                
               //inner loop
               while(parceB >= 0){
               intB = b.charAt(parceB)-48;
               
               //do math here
               tempProduct = (intA * intB) + carry;
              
               if(tempProduct >= 10){
                   carry = tempProduct/10;
                   tempProduct = tempProduct%10;
               
               }
               else{
                   carry = 0;
               }
               
               temporaryAnswer = tempProduct + temporaryAnswer;    
               parceB--;
               }
               
               
               
               
               
              
               temporaryAnswer = carry + temporaryAnswer + extraZeros;
               hold = new InfiniteInteger(temporaryAnswer);
               total = total.plus(hold);
               
               //reset parse b and temporaryAnswer also change the extra zeros
               parceB = b.length()-1;
               carry = 0;//very important 
               temporaryAnswer = "";
               extraZeros = extraZeros + "0";
               
               parceA--;
           }
           
           
           
           output = total.toString();
           InfiniteInteger answer = new InfiniteInteger(output);
           
           //changing signs
           if(this.isNegative() == false && anInfiniteInteger.isNegative() == true){
               answer.isNegative = true;
           }
           if(this.isNegative() == true && anInfiniteInteger.isNegative() == false){
               answer.isNegative = true;
           }
           
            return answer;
          
	}
	
	/**
	 * Generates a string representing this infinite integer. If this infinite integer
	 * is a negative number a minus symbol should be in the front of numbers. For example,
	 * "-12345678901234567890". But if the infinite integer is a positive number, no symbol
	 * should be in the front of the numbers (e.g., "12345678901234567890").
	 * @return a string representing this infinite integer number.
	 */
	public String toString()
	{
		int count = 0;
                String returnString = "";
                
               
                if(this.getValueAt(0) == 0){
                    return "0";
                }
                
                
                while(count < storageArray.length){
                    returnString = returnString + (storageArray[count]);
                   
                    count++;
                }
                
                
                
                //add the negative again
                if(isNegative()){
                    returnString = "-" + returnString;
                }        
                return returnString;
                
	}
	
	/**
	 * Compares this infinite integer with anInfiniteInteger
	 * @return either -1, 0, or 1 as follows:
	 * If this infinite integer is less than anInfiniteInteger, return -1.
	 * If this infinite integer is equal to anInfiniteInteger, return 0.
	 * If this infinite integer is greater than anInfiniteInteger, return 1.
	 */
	public int compareTo(final InfiniteInteger anInfiniteInteger)
	{
            //compare if positive or negative
            if(isNegative()==true && anInfiniteInteger.isNegative()==false){
                return -1;
            }
            if(isNegative()==false && anInfiniteInteger.isNegative()==true){
                return 1;
            }
            
            //compare lengths
            if(this.getNumberOfDigits() > anInfiniteInteger.getNumberOfDigits()){
                return 1;
            }
            if(this.getNumberOfDigits() < anInfiniteInteger.getNumberOfDigits()){
                return -1;
            }
            
            //look at individual elements
            int count = 0;
            while(count < getNumberOfDigits()){
               
                if(getValueAt(count) > anInfiniteInteger.getValueAt(count)){
                    return 1;
                }
                if(getValueAt(count) < anInfiniteInteger.getValueAt(count)){
                    return -1;
                }
                count++;
            }
             
            return 0;
	}
        
        //Extra methods I Created below.
        
        public int getValueAt(int location){
            
            return storageArray[location];
        }
        
        public String removeZeros(String strInput){
            String temp = "";
            int count = 0;
            
            //dealing with zero case
            if(strInput.length() == 1 && strInput.charAt(0) == '0'){
                return "0";
            }
            
            while(strInput.charAt(count) == '0' && count < strInput.length()-1){
                count++;
            }
            while(count < strInput.length()){
                temp = temp + strInput.charAt(count);
                count++;
            }
            return temp;
        }
        
        //only removes the '-' from a string. It does not change any booleans
          public String removeNegative(String strInput){
            String temp = "";
            int count = 0;
            while(strInput.charAt(count) == '-' && count < strInput.length()-1){
                count++;
            }
            while(count < strInput.length()){
                temp = temp + strInput.charAt(count);
                count++;
            }
            return temp;
        }
          
        public InfiniteInteger getAbsoluteValue(InfiniteInteger i){
            InfiniteInteger s = new InfiniteInteger(i.toString());
            s.isNegative = false;
            return s;
        }
        
        public InfiniteInteger changeSign(InfiniteInteger i){
            InfiniteInteger s = new InfiniteInteger(i.toString());
            if(s.isNegative() == true){
            s.isNegative = false;
            }
            else if(s.isNegative() == false){
            s.isNegative = true;
            }
            
            return s;
        }
}
