package kz.xaw.ovaanimerp.util;
import com.ibm.icu.text.Transliterator;


    public class TranscriptionUtil {

        private static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";
        private static final String LATIN_TO_CYRILLIC = "Latin-Cyrillic";

        public static String transliterateToLatin(String cyrillic) {
            Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
            return toLatinTrans.transliterate(cyrillic);

        }

        public static String transliterateToCyrillic(String latin){
            Transliterator toCyrillicTrans = Transliterator.getInstance(LATIN_TO_CYRILLIC);
            return toCyrillicTrans.transliterate(latin);
        }
    }