package com.naitiks.kotlincalculator


/**
 * Created by Naitik on 8/28/2017.
 */
class CalculationHelper{
    private val expList = listOf('+', '-', 'x', '/')

    private fun addition(val1 : Double, val2 : Double): Double{
        return val1 + val2
    }

    private fun minus(val1 : Double, val2 : Double): Double{
        return val1 - val2
    }

    private fun multiplication(val1 : Double, val2 : Double): Double{
        return val1 * val2
    }

    private fun division(val1 : Double, val2 : Double): Double{
        return val1 / val2
    }

    private fun mod(val1 : Double, val2 : Double): Double{
        return (val1 * val2) / 100
    }

    fun calculateIt(useInput: String) : Double{
        var lastExp = "";
        var returnVal = 0.0
        if(useInput.isEmpty())
            return 0.0
        else{
            var val1 = ""
            var val2 = ""
            val trimmed = useInput.trim();
            for (index in trimmed.indices){
                var currentVal = trimmed[index]
                if(expList.contains(currentVal) && lastExp == ""){
                    lastExp = currentVal.toString()
                }else if(expList.contains(currentVal) && lastExp != ""){
                    returnVal += manageAction(val1, val2, lastExp)
                } else if(currentVal == '#' && lastExp != ""){
                    returnVal += manageAction(val1, val2, lastExp)
                }else if(currentVal == '%' && lastExp != ""){
                    returnVal += manageAction(val1, val2, "%")
                }else if(lastExp != ""){
                    val2 += currentVal.toString()
                }else{
                    val1 += currentVal.toString()
                }
            }
        }
        return returnVal
    }

    fun manageAction(val1: String, val2: String, action: String) :Double{
        if(val1.isEmpty() && (!val2.isEmpty())) return val2.toDouble()
        else if(val2.isEmpty() && (!val1.isEmpty())) return  val1.toDouble()
        else if(val1.isEmpty() && val2.isEmpty()) return 0.0
        else if(action == "+") return this.addition(val1.toDouble(), val2.toDouble())
        else if(action == "-") return this.minus(val1.toDouble(), val2.toDouble())
        else if(action == "x") return this.multiplication(val1.toDouble(), val2.toDouble())
        else if(action == "/") return this.division(val1.toDouble(), val2.toDouble())
        else if(action == "%") return this.mod(val1.toDouble(), val2.toDouble())
        else return 0.0
    }
}