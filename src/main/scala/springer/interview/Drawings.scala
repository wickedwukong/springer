package springer.interview

object Drawings {
  type Canvas = List[List[Char]]

  def rectangleDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Canvas => Canvas = {
    _.zipWithIndex.map {
      case (row, rowIndex) if rowIndex == yStart || rowIndex == yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd) 'x' else cell
        }
      }
      case (row, rowIndex) if rowIndex > yStart && rowIndex < yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex == xStart || cellIndex == xEnd) 'x' else cell
        }
      }
      case (row, _) => row
    }
  }

  def lineDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Canvas => Canvas = {
    _.zipWithIndex.map {
      case (row, rowIndex) if rowIndex >= yStart && rowIndex <= yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd) 'x' else cell
        }
      }
      case (row, _) => row
    }

  }

  def bucketFill(xAxis: Int, yAxis: Int, color: Char): Canvas => Canvas = {
    _.map(row => {row.map(c => if (c == ' ') color else c)})
  }

  def canvasDrawing(xAxis: Int, yAxis: Int): Canvas => Canvas = {
    _ => {
      val numberOfRows = yAxis + 2
      val numberOfColumns = xAxis + 2

      (0 until numberOfRows).map {
        case x if x == 0 || x == numberOfRows - 1 => 0.until(numberOfColumns).map(_ => '-').toList
        case _ => 0.until(numberOfColumns).map {
          case x if x == 0 || x == numberOfColumns - 1 => '|'
          case _ => ' '
        }.toList
      }.toList
    }
  }
}

