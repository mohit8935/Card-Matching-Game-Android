# Card-Matching-Game-Android
This is a card mathing andoird game with the three levels created using android studio.Every image
is stored in pair and they have to nd out the pair.This game was tricky to made as its design
needs to be simple and the game should work without any hassle and they can easily play game.So I decided to have 3 levels in the game. First level will have 4 image buttons which means 2
image pair and it will have 3 sub levels. Second level have 8 image buttons and have 2 sub levels
.Final level have 12 image buttons and only there is one level. This was decided so the game is not
too long and boring. There were many problems which occur during the implementation one of
them it was that game was crashing after the images which were in sub button were no matching
this was a bug which was handled by providing tag to each button and that tag represents the
position of button and images are stored in array so whenever image button is pressed it takes
tag from it and gets the image from the array. Second problem with the code was that it was
having same image in the same position so shue method was applied to shue the image values
in array and get the dierent image for the particular position of image button every time. Next
bug was that it was crashing every time when it was starting the sub level which was tackle in the
appropriate way.
The another bug found was that when one card is pressed and then the same card is pressed
again it matches and points are awarded this bug was tackled by enabling the button which is
pressed once to false so this image button would not work if once pressed and it will only work
after two dierent cards are open.
