using Payroll;

namespace PayrollTest
{
    public class UnitTest1 : IDisposable
    {
        public PayrollClass payrollObj;

        public void Dispose()
        {
            //throw new NotImplementedException();
            //shut down the test
        }

        public UnitTest1()
        {
            payrollObj = new PayrollClass();
            payrollObj.Hours = 20;
            payrollObj.Rate = 15;
        }

        [Fact]
        public void TestGrossPayIsCorrect()
        {
            //Arrange
            double expected = 300;
            //Act
            double actual = payrollObj.GrossPay;
            //Assert
            Assert.Equal(expected, actual);
        }
        [Fact]
        public void TestLocalTaxIsCorrect()
        {
            //Arrange
            double TaxRate = .035;
            double expected = 300 * TaxRate;
            //Act
            double actual = payrollObj.LocalTax(TaxRate);
            //Assert
            Assert.Equal(expected, actual);
        }
        [Theory]
        [InlineData(15, 20, 300)]
        [InlineData(15, 40, 600)]
        [InlineData(15, 45, 712.5)]
        public void TestOvertimePayIsCorrect
            (double rate, double hours,  double expected)
        {
            //Arrange
            payrollObj.Rate = rate;
            payrollObj.Hours = hours;
            //Act
            double actual = payrollObj.GrossPay;
            //Assert
            Assert.Equal (expected, actual);

        }
    }
}