using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Payroll
{
    public class PayrollClass
    {
        public double Hours { get; set; }
        public double Rate { get; set; }
        private double _grossPay;

        public double GrossPay
        {
            get {
                if (Hours <= 40)
                {
                    return Hours * Rate;
                }
                else if(Hours > 40)
                {
                    return 40 * Rate + (Hours - 40) * Rate * 1.5;
                }
                else
                {
                    return 0;
                }
            }//end of get
     
            set {  }
        }

        public double LocalTax(double TaxRate)
        {
            return GrossPay * TaxRate; 
        }


        public PayrollClass() {
            Hours = 0;
            Rate = 0;
        }

        public PayrollClass(double hours, double rate)
        {
            Hours = hours;
            Rate = rate;
        }


    }


}
