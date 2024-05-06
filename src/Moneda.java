import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public record Moneda(String base_code,
                     JsonObject conversion_rates) {
}
