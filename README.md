# BitMap Transformer
This is a Bitmap Transformer.

### Authors; Dan-Huy Le and James Dansie
This file is to transform a bitmap image (ending in .bmp). To call the function;
From the root level type 'input-file-path output-file-path transfrom-name' in the command line. Accepted transforms are; 'flipHoriz', 'flipVert', and 'tiedye'.

For example, if running with gradle, go to level with a build.gradle and type int to the terminal;
```./gradlew run --args='test.bmp newtest.bmp flipHoriz```
This will take in test.bmp and flip it horizontally, and save it as newtest.bmp.