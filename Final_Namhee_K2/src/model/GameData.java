package model;

public class GameData
{
	public static int game_Score = 0;
	public static int player_HitPoint = 0;

	public static int player_Speed;
	public static int missile_Speed;
	public static int fire_Speed;
	public static int enemy_Speed;
	public static int life_Speed;

	public static void init()
	{
		game_Score = 0;
		player_HitPoint = 3;

		player_Speed = 5;
		missile_Speed = 10;
		fire_Speed = 10;
		enemy_Speed = 6;
		life_Speed = 2;

	}

}
