package hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final calculator calculator = new calculator();
    private final List<String> history = new ArrayList<>();

    @GetMapping("/add")
    public double add(@RequestParam double num1, @RequestParam double num2) {
        double result = calculator.add(num1, num2);
        history.add(num1 + " + " + num2 + " = " + result);
        return result;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double num1, @RequestParam double num2) {
        double result = calculator.subtract(num1, num2);
        history.add(num1 + " - " + num2 + " = " + result);
        return result;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1, @RequestParam double num2) {
        double result = calculator.multiply(num1, num2);
        history.add(num1 + " * " + num2 + " = " + result);
        return result;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double num1, @RequestParam double num2) {
        double result = calculator.divide(num1, num2);
        history.add(num1 + " / " + num2 + " = " + result);
        return result;
    }

    @GetMapping("/history")
    public List<String> getHistory() {
        return history;
    }
/*
    @GetMapping("/clearHistory")
    public void clearHistory() {
        history.clear();
    } */
    
    @GetMapping("/clearHistory")
    public ResponseEntity<String> clearHistory() {
        history.clear();
        return ResponseEntity.ok("clear history");
    }
}
