package zzy.inventorySystem.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class GameOfLifeController {
	 private static final int defaultRow = 15;
	   private static final int defaultCol = 15;
    @RequestMapping("/init")
    public @ResponseBody Object getInit(@RequestParam(required = false) Integer row, @RequestParam(required = false) Integer col) {
		if (null == row) row = defaultRow;
        if (null == col) col = defaultCol;
        cellarrays cellularArray = new cellarrays(row, col);
        return cellularArray;
    }
    @RequestMapping("/multiply_once")
    public @ResponseBody Object mulonce(@RequestBody(required = false) cellarrays now) {
    	cellarrays next =now.multiply_once(now);
         return next;
    }
}
