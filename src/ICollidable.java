public interface ICollidable {
    boolean colDetect(Ball ball);
    void colResponse(Ball ball);
}