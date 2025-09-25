import java.awt.*;
import java.util.*;

public class ColorManager {
    private final Random random;
    private final Map<String, Integer> colorCache = new HashMap<>();

    public ColorManager(Random random) {
        this.random = random;
    }

    public <T> T getObjectColor(ArrayList<T> palette, String objectKey) {
        if (!colorCache.containsKey(objectKey)) {
            int randomIndex = random.nextInt(palette.size());
            colorCache.put(objectKey, randomIndex);
        }
        int index = colorCache.get(objectKey);
        return palette.get(index);
    }

    public Color getColor(ArrayList<Color> palette, String objectKey) {
        if (!colorCache.containsKey(objectKey)) {
            int randomIndex = random.nextInt(palette.size());
            colorCache.put(objectKey, randomIndex);
        }
        int index = colorCache.get(objectKey);
        return palette.get(index);
    }
}