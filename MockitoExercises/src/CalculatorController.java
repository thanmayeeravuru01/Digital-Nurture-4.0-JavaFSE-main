import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int add(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a - b;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a * b;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("a") int a, @RequestParam("b") int b) {
        if (b == 0) {
            return "Cannot divide by zero";
        }
        return String.valueOf((double) a / b);
    }

    @GetMapping("/mod")
    public String mod(@RequestParam("a") int a, @RequestParam("b") int b) {
        if (b == 0) {
            return "Cannot perform modulus by zero";
        }
        return String.valueOf(a % b);
    }

    @GetMapping(value = "/square", produces = "text/plain")
    public String square(@RequestParam("a") int a) {
        return String.valueOf(a * a);
    }
    @GetMapping(value = "/power", produces = "text/plain")
    public String power(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf((int) Math.pow(a, b));
    }
    @GetMapping(value = "/modulus", produces = "text/plain")
    public String modulus(@RequestParam("a") int a, @RequestParam("b") int b) {
        if (b == 0) {
            return "Cannot divide by zero";
        }
        return String.valueOf(a % b);
    }
    @GetMapping(value = "/negate", produces = "text/plain")
    public String negate(@RequestParam("a") int a) {
        return String.valueOf(-a);
    }

}
