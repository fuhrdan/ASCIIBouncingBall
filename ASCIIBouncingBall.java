public class ASCIIBouncingBall {
    public static void main(String[] args) {
        // Set the size of the box and ball speed
        int width = 80;
        int height = 40;
        int ballX = width / 2; // Ball's starting X position
        int ballY = height / 2; // Ball's starting Y position
        int ballDX = 1; // Ball's movement speed in X
        int ballDY = 1; // Ball's movement speed in Y

        // Draw the box once at the beginning
        drawBox(width, height);

        // Game loop to animate the ball
        while (true) {
            // Sleep for 50 milliseconds (controls speed)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear the ball's previous position by overwriting it with a space
            clearBall(ballX, ballY);

            // Update the ball's position
            ballX += ballDX;
            ballY += ballDY;

            // Bounce the ball off the walls
            if (ballX <= 1 || ballX >= width - 2) {
                ballDX = -ballDX; // Reverse horizontal direction
            }
            if (ballY <= 1 || ballY >= height - 2) {
                ballDY = -ballDY; // Reverse vertical direction
            }

            // Draw the ball at its new position
            drawBall(ballX, ballY);
        }
    }

    // Method to draw the ASCII box once at the beginning
    private static void drawBox(int width, int height) {
        // Draw top border
        System.out.println("#".repeat(width));

        // Draw middle of the box
        for (int y = 1; y < height - 1; y++) {
            System.out.print("#");
            for (int x = 1; x < width - 1; x++) {
                System.out.print(" "); // Empty space
            }
            System.out.println("#");
        }

        // Draw bottom border
        System.out.println("#".repeat(width));
    }

    // Method to draw the ball at a specific position
    private static void drawBall(int x, int y) {
        // Move the cursor to the ball's position using ANSI escape codes
        System.out.print("\033[" + (y + 1) + ";" + (x + 1) + "H");
        System.out.print("O"); // Ball represented by 'O'
    }

    // Method to clear the ball's previous position (overwrite with space)
    private static void clearBall(int x, int y) {
        // Move the cursor to the previous ball's position and overwrite it with a space
        System.out.print("\033[" + (y + 1) + ";" + (x + 1) + "H");
        System.out.print(" "); // Clear the ball's old position
    }
}
