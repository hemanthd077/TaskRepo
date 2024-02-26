package helper;

import commonChecker.CommonChecker;
import car.Car;
import car.SCross;
import car.Swift;
import car.Xuv;
import customException.CustomException;

public class InheritanceHelper {
    public static String invokeMethod(Car carObject,String inputString) throws CustomException {
        CommonChecker.checkNull(carObject);
        CommonChecker.checkNull(inputString);
        if(carObject instanceof Swift){
            return inputString;
        } else if (carObject instanceof Xuv) {
            return inputString;
        }
        else if(carObject instanceof SCross){
            return inputString;
        }
        return null;
    }

    public static String swiftInvokeMethod(Swift swiftObject) throws CustomException{
        CommonChecker.checkNull(swiftObject);
        return swiftObject.getClass().getSimpleName();
    }
}
